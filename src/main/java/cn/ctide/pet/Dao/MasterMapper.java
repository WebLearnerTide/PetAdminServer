package cn.ctide.pet.Dao;

import java.util.List;

import cn.ctide.pet.Model.Master;

public interface MasterMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(Integer mId);
    
    List<Master> selectSelective(Master record);
    

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);
}