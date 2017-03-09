package cn.ctide.pet.Service;

import java.util.List;

import cn.ctide.pet.Model.Pet;

public interface PetService {
	
	int addPet(Pet pet) throws Exception;
	
	List<Pet> getByMasterId(Integer mId)  throws Exception;
	
	Pet getByPetId(Integer petId) throws Exception;
}
