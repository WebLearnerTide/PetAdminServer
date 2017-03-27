package cn.ctide.pet.Service;

import cn.ctide.pet.Model.Album;
import cn.ctide.pet.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/27.
 */
public interface AlbumService {
    Map getPetAlbum(Page page, Integer petId);

    void addAlbum(Album album) throws Exception;
}
