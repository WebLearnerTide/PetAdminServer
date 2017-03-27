package cn.ctide.pet.Service;

import cn.ctide.pet.Model.Ad;

import java.util.List;

/**
 * Created by Anker on 2017/3/27.
 */
public interface AdService {
    void addAd(Ad ad) throws Exception;
    List<Ad> getAdList() throws Exception;
}
