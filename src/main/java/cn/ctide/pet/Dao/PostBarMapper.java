package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PostBar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostBarMapper {
    int deleteByPrimaryKey(Integer barId);

    int insert(PostBar record);

    int insertSelective(PostBar record);

    PostBar selectByPrimaryKey(Integer barId);

    int updateByPrimaryKeySelective(PostBar record);

    int updateByPrimaryKey(PostBar record);

    List<PostBar> getUnFollowPostBar(@Param("mId") Integer mId);

    List<PostBar> getFollowPostBar(@Param("mId") Integer mId);
}