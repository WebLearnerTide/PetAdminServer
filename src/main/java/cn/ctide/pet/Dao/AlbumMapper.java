package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Album;

import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    List<Album> getPetAlbum(Integer petId);
}