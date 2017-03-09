package cn.ctide.pet.Service;

import java.util.List;

import cn.ctide.pet.Model.Petclass;

public interface PetclassService {
	
	List<Petclass> getPetclassList(Petclass petclass) throws Exception;
	
	List<Petclass> getBuilds() throws Exception;

}
