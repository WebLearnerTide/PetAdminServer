package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PetLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetLogMapper {
    int deleteByPrimaryKey(String plogCode);

    int insert(PetLog record);

    int insertSelective(PetLog record);

    PetLog selectByPrimaryKey(String plogCode);

    int updateByPrimaryKeySelective(PetLog record);

    int updateByPrimaryKey(PetLog record);

    List<PetLog> getLogsByPet(@Param("pId") Integer pId);
}