package cn.ctide.pet.Service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.ctide.pet.container.OSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ctide.pet.Dao.PetMapper;
import cn.ctide.pet.Model.Pet;
import cn.ctide.pet.Service.PetService;

@Service("petService")

public class PetServiceImpl implements PetService{

	@Autowired
	private PetMapper petMapper;
	
	
	@Override
	public int addPet(Pet pet) throws Exception {
		// TODO Auto-generated method stub
		int result = petMapper.insertSelective(pet);
		if (result==1) {
			return result;
		}else{
			throw new Exception("添加失败");
		}
	}


	@Override
	public List<Pet> getByMasterId(Integer mId) throws Exception {
		List<Pet> list = null;
		Pet pet = new Pet();
		pet.setmId(mId);
		try {
			list = petMapper.selectSelective(pet);
			if (null==list || list.size()==0) {
				return new ArrayList<Pet>();
			}
			return list;
		} catch (Exception e) {
			throw new Exception("查询宠物失败");
		}
	}


	@Override
	public Pet getByPetId(Integer petId) throws Exception {
		Pet pet = null;
		try {
			pet = petMapper.selectByPrimaryKey(petId);
			if (null==pet) {
				throw new Exception("宠物不存在");
			}
			pet.setPetPhoto(OSS.INSTANCE.generateUrl(pet.getPetPhoto(), OSS.INSTANCE.PET_STYLE));
		} catch (Exception e) {
			throw new Exception("查找宠物失败");
		}
		return pet;
	}

	@Override
	public void updatePet(Pet pet) throws Exception {
		int count = petMapper.updateByPrimaryKeySelective(pet);
		if (count!=1) {
			throw new Exception("添加失败");
		}
	}

}
