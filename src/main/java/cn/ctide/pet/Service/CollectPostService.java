package cn.ctide.pet.Service;

import cn.ctide.pet.Model.MPCollect;
import cn.ctide.pet.Model.MPCollectKey;

/**
 * Created by Anker on 2017/3/23.
 */
public interface CollectPostService {
    void addCollect(MPCollect mpCollect) throws Exception;

    void deleteCollect(MPCollectKey key) throws Exception;

    MPCollect getCollectByKey(MPCollectKey key) throws Exception;
}
