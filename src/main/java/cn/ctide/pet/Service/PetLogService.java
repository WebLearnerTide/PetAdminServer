package cn.ctide.pet.Service;

import cn.ctide.pet.Model.PetLog;

import java.util.List;

/**
 * Created by Anker on 2017/3/26.
 */
public interface PetLogService {
    List<PetLog> getLogsByPet(Integer pId) throws Exception;
    void addPetLog(PetLog log) throws Exception;
}
