package repository.impl;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import model.SportsEquipment;
import repository.mapper.SportsEquipmentMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class SportRepository {
    private final HikariDataSource dataSource;
    private final SportsEquipmentMapper mapper;
    private final static String GET_BY_ID = "select * from sports_inventory where id = ?";
    private final static String GET_ALL = "select * from sports_inventory";


    public SportsEquipment getById(int id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapper.mapRow(resultSet);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SportsEquipment> getAll() {
        try (Connection connection = dataSource.getConnection()){
            List<SportsEquipment> result = new ArrayList<>();
            ResultSet resultSet = connection.createStatement().executeQuery(GET_ALL);
            if (resultSet.next()) {
                do {
                    result.add(mapper.mapRow(resultSet));
                } while (resultSet.next());
                return result;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
