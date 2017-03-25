package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List getReply(@Param("mId") Integer mId);

    void readReply(@Param("mId") Integer mId);

    Integer getReplyCount(@Param("mId") Integer mId);
}