package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.AdMapper;
import cn.ctide.pet.Model.Ad;
import cn.ctide.pet.Service.AdService;
import cn.ctide.pet.container.OSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anker on 2017/3/27.
 */
@Service("adService")
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;

    @Override
    public void addAd(Ad ad) throws Exception {
        int count = adMapper.insertSelective(ad);
        if (count!=1) {
            throw new Exception("添加失败");
        }
    }

    @Override
    public List<Ad> getAdList() throws Exception {
        List<Ad> list = adMapper.getLatestAd();

        if (null==list || list.size()==0) {
            throw new Exception("暂无广告");
        }
        for (int i=0; i<list.size(); i++) {
            Ad ad = list.get(i);
            ad.setAdImg(OSS.INSTANCE.generateUrl(ad.getAdImg(), ""));
            list.set(i, ad);
        }
        return list;
    }
}
