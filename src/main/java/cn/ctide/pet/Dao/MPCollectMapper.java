package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.MPCollect;
import cn.ctide.pet.Model.MPCollectKey;

public interface MPCollectMapper {
    int deleteByPrimaryKey(MPCollectKey key);

    int insert(MPCollect record);

    int insertSelective(MPCollect record);

    MPCollect selectByPrimaryKey(MPCollectKey key);

    int updateByPrimaryKeySelective(MPCollect record);

    int updateByPrimaryKey(MPCollect record);
}