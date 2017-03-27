package cn.ctide.pet.Service;

import cn.ctide.pet.Model.Post;
import cn.ctide.pet.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/17.
 */
public interface PostService {
    Map getHotPost(Page page);

    int addNewPost(Post post) throws Exception;

    Map getMyPost(Page page, Integer mId);

    Map getPostDetail(Page p, Integer pId);

    Map getCollectPost(Page page, Integer mId);

    Map getBarPost(Page p, Integer barId);

    List getBarTopPost(Integer barId) throws Exception;

    Integer getNextId();
}
