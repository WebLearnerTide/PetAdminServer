package cn.ctide.pet.Dao;

import cn.ctide.pet.Model.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    List<Album> getPetAlbum(@Param("petId") Integer petId);
}