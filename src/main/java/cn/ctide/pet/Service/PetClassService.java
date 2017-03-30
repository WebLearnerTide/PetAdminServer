package cn.ctide.pet.Service;

import java.util.List;

import cn.ctide.pet.Model.PetClass;

public interface PetClassService {
	
	List<PetClass> getPetClassList(PetClass petClass) throws Exception;
	
	List<PetClass> getBuilds() throws Exception;

    List<PetClass> getMasterClass(Integer mId);
}
