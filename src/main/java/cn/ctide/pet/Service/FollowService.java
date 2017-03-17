package cn.ctide.pet.Service;

import cn.ctide.pet.Model.FollowKey;

/**
 * Created by Anker on 2017/3/17.
 */
public interface FollowService {
    void addFollow(FollowKey followKey) throws Exception;
}
