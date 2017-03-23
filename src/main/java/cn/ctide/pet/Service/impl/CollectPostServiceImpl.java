package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.MPCollectMapper;
import cn.ctide.pet.Model.MPCollect;
import cn.ctide.pet.Model.MPCollectKey;
import cn.ctide.pet.Service.CollectPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anker on 2017/3/23.
 */
@Service("collectPostService")
public class CollectPostServiceImpl implements CollectPostService {
    @Autowired
    private MPCollectMapper mapper;

    @Override
    public void addCollect(MPCollect mpCollect) throws Exception {
        try {
            int count = mapper.insertSelective(mpCollect);
            if (count!=1) {
                throw new Exception("收藏失败");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteCollect(MPCollectKey key) throws Exception {
        try {
            int count = mapper.deleteByPrimaryKey(key);
            if (count!=1) {
                throw new Exception("删除失败");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public MPCollect getCollectByKey(MPCollectKey key) throws Exception {
        try {
            MPCollect collect = mapper.selectByPrimaryKey(key);
            if (null==collect) {
                throw new Exception();
            }
            return collect;
        } catch (Exception e) {
            throw e;
        }
    }
}
