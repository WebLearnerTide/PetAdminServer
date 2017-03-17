package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PostBarMapper;
import cn.ctide.pet.Model.PostBar;
import cn.ctide.pet.Service.PostBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anker on 2017/3/17.
 */
@Service("postBarService")
public class PostBarServiceImpl implements PostBarService {
    @Autowired
    private PostBarMapper postBarMapper;

    @Override
    public List<PostBar> getPostBarList(Integer mId, boolean follow) throws Exception {
        List<PostBar> list = null;
        try {
            if (!follow) {
                list = postBarMapper.getUnFollowPostBar(mId);
            } else {
                list = postBarMapper.getFollowPostBar(mId);
            }
            if (null==list || list.size()==0) {
                list = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("获取贴吧失败");
        }
        return list;
    }
}
