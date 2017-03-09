package cn.ctide.pet.Dao;

import java.util.List;

import cn.ctide.pet.Model.Petclass;

public interface PetclassMapper {
    int deleteByPrimaryKey(Integer petcId);

    int insert(Petclass record);

    int insertSelective(Petclass record);

    Petclass selectByPrimaryKey(Integer petcId);
    
    List<Petclass> selectSelective(Petclass record);
    
    List<Petclass> getPetBuild();

    int updateByPrimaryKeySelective(Petclass record);

    int updateByPrimaryKey(Petclass record);
}