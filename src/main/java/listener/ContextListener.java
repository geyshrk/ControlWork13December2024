package listener;

import config.DataSourceConfiguration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;
import repository.impl.SportRepository;
import repository.mapper.SportsEquipmentMapper;
import service.SportsService;

import java.io.IOException;
import java.util.Properties;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataSourceConfiguration configuration =
                new DataSourceConfiguration(properties);

        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(configuration.hikariDataSource())
                .load();

        flyway.migrate();

        SportRepository sportRepository =
                new SportRepository(configuration.hikariDataSource(), new SportsEquipmentMapper());

        SportsService sportsService = new SportsService(sportRepository);

        ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("sportsService", sportsService);
    }
}
