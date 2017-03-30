package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PostClassMapper;
import cn.ctide.pet.Model.PostClass;
import cn.ctide.pet.Service.PostClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/22.
 */
@Service("postClassService")
public class PostClassServiceImpl implements PostClassService {
    @Autowired
    private PostClassMapper postClassMapper;

    @Override
    public List<PostClass> getPostClass() throws Exception {
        try {
            List<PostClass> postClasses = postClassMapper.selectAll();
            if (null==postClasses || postClasses.size()==0) {
                throw new Exception("查询帖子分类失败");
            }
            return postClasses;
        } catch (Exception e) {
            throw e;
        }

    }

}
