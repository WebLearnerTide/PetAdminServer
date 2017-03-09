package cn.ctide.pet.Dao;

import java.util.List;

import cn.ctide.pet.Model.Pet;

public interface PetMapper {
    int deleteByPrimaryKey(Integer petId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Integer petId);
    
    List<Pet> selectSelective(Pet pet);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
}