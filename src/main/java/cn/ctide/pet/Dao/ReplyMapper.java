package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}