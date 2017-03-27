package cn.ctide.pet.Service;

import cn.ctide.pet.Model.PostResources;

import java.util.List;

/**
 * Created by Anker on 2017/3/27.
 */
public interface PostResourcesService {
    void addPostResources(PostResources resources) throws Exception;

    List<PostResources> getResources(Integer pId);
}
