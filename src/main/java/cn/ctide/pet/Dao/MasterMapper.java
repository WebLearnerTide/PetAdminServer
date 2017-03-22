package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);

    List<Master> selectSelective(Master master);

    Master callSign(@Param("mId") Integer mId);
}