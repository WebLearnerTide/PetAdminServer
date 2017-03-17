package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PetLog;

public interface PetLogMapper {
    int deleteByPrimaryKey(String plogCode);

    int insert(PetLog record);

    int insertSelective(PetLog record);

    PetLog selectByPrimaryKey(String plogCode);

    int updateByPrimaryKeySelective(PetLog record);

    int updateByPrimaryKey(PetLog record);
}