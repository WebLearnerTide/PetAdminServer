package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Post;
import cn.ctide.pet.Model.PostDetail;
import org.apache.ibatis.annotations.Param;

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

    List<PostDetail> getPostDetail(@Param("pId") Integer pId);

    List getCollectPost(@Param("mId") Integer mId);

    List getBarPost(@Param("barId") Integer barId, @Param("isTop") boolean isTop);
}