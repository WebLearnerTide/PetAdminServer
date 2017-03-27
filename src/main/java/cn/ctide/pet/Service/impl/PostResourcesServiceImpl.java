package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PostResourcesMapper;
import cn.ctide.pet.Model.PostResources;
import cn.ctide.pet.Service.PostResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anker on 2017/3/27.
 */
@Service("postResourcesService")
public class PostResourcesServiceImpl implements PostResourcesService {
    @Autowired
    private PostResourcesMapper postResourcesMapper;

    @Override
    public void addPostResources(PostResources resources) throws Exception {
        int count = postResourcesMapper.insertSelective(resources);
        if (count!=1) {
            throw new Exception("添加失败");
        }
    }

    @Override
    public List<PostResources> getResources(Integer pId) {
        return postResourcesMapper.getByPId(pId);
    }
}
