package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PostClass;

public interface PostClassMapper {
    int deleteByPrimaryKey(Integer pcId);

    int insert(PostClass record);

    int insertSelective(PostClass record);

    PostClass selectByPrimaryKey(Integer pcId);

    int updateByPrimaryKeySelective(PostClass record);

    int updateByPrimaryKey(PostClass record);
}