package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PostClass;

import java.util.List;

public interface PostClassMapper {
    int deleteByPrimaryKey(Integer pcId);

    int insert(PostClass record);

    int insertSelective(PostClass record);

    PostClass selectByPrimaryKey(Integer pcId);

    int updateByPrimaryKeySelective(PostClass record);

    int updateByPrimaryKey(PostClass record);

    List<PostClass> selectAll();

}