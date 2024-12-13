package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SportsEquipment {
    private int id;
    private String name;
    private String parameters;
    private int age;
    private String storageConditions;
}
