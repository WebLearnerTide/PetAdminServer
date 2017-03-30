package cn.ctide.pet.Dao;

import java.util.List;

import cn.ctide.pet.Model.PetClass;
import org.apache.ibatis.annotations.Param;

public interface PetClassMapper {
    int deleteByPrimaryKey(Integer petcId);

    int insert(PetClass record);

    int insertSelective(PetClass record);

    PetClass selectByPrimaryKey(Integer petcId);
    
    List<PetClass> selectSelective(PetClass record);
    
    List<PetClass> getPetBuild();

    int updateByPrimaryKeySelective(PetClass record);

    int updateByPrimaryKey(PetClass record);

    List<PetClass> getPetClass(@Param("mId") Integer mId);
}