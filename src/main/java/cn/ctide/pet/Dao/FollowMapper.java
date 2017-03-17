package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.FollowKey;

public interface FollowMapper {
    int deleteByPrimaryKey(FollowKey key);

    int insert(FollowKey record);

    int insertSelective(FollowKey record);
}