package service;

import lombok.AllArgsConstructor;
import model.SportsEquipment;
import repository.impl.SportRepository;

import java.util.List;
@AllArgsConstructor
public class SportsService {
    private SportRepository sportRepository;
    public List<SportsEquipment> getListSportsEquipment(){
        return sportRepository.getAll();
    }
    public SportsEquipment getById(int id){
        return sportRepository.getById(id);
    }
}
