package cn.ctide.pet.Service;

import cn.ctide.pet.Model.PostBar;

import java.util.List;

/**
 * Created by Anker on 2017/3/17.
 */
public interface PostBarService {
    List<PostBar> getPostBarList(Integer mId, boolean follow) throws Exception;
}
