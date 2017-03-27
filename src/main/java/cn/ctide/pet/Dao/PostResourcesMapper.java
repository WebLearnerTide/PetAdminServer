package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.PostResources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostResourcesMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(PostResources record);

    int insertSelective(PostResources record);

    PostResources selectByPrimaryKey(Integer resId);

    List<PostResources> getByPId(@Param("pId") Integer pId);

    int updateByPrimaryKeySelective(PostResources record);

    int updateByPrimaryKey(PostResources record);
}