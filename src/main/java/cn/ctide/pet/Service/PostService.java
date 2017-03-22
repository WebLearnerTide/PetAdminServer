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
}
