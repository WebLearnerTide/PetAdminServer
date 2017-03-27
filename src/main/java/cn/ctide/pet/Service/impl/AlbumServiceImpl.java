package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.AlbumMapper;
import cn.ctide.pet.Model.Album;
import cn.ctide.pet.Model.PostDetail;
import cn.ctide.pet.Model.PostResources;
import cn.ctide.pet.Service.AlbumService;
import cn.ctide.pet.container.OSS;
import cn.ctide.pet.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/27.
 */
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper mapper;

    @Override
    public Map getPetAlbum(Page page, Integer petId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List<Album> list = mapper.getPetAlbum(petId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                for (int i=0;i<list.size();i++) {
                    Album a = list.get(i);
                    String url = a.getPhotoUrl();
                    a.setMinUrl(OSS.INSTANCE.generateUrl(url, OSS.INSTANCE.USER_STYLE));
                    a.setPhotoUrl(OSS.INSTANCE.generateUrl(url, ""));
                    list.set(i, a);
                }
                result.put("total", ((com.github.pagehelper.Page)list).getPages());
                result.put("page", ((com.github.pagehelper.Page)list).getPageNum());
                result.put("empty", false);
                result.put("album", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "获取失败！" + e.getMessage());
        }
        return result;
    }

    @Override
    public void addAlbum(Album album) throws Exception {
        int count = mapper.insertSelective(album);
        if (count!=1) {
            throw new Exception("添加失败");
        }
    }
}
