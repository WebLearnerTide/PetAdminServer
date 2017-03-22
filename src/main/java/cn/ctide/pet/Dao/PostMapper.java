package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Post;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List getHotPost(@Param("pTime") Date date);

    List getMyPosts(@Param("mId") Integer mId);
}