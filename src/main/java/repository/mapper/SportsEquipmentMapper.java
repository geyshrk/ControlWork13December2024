package repository.mapper;

import model.SportsEquipment;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SportsEquipmentMapper {

    public SportsEquipment mapRow(ResultSet resultSet) throws SQLException {
        return SportsEquipment.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .parameters(resultSet.getString("parameters"))
                .age(resultSet.getInt("age"))
                .storageConditions(resultSet.getString("storage_conditions"))
                .build();
    }

}
