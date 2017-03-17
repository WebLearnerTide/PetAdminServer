package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.FollowMapper;
import cn.ctide.pet.Model.FollowKey;
import cn.ctide.pet.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anker on 2017/3/17.
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;


    @Override
    public void addFollow(FollowKey followKey) throws Exception {
        try {
            int result = followMapper.insertSelective(followKey);
            if (result!=1) {
                throw new Exception("添加失败！");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
