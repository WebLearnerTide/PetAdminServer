package cn.ctide.pet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Model.Pet;
import cn.ctide.pet.Service.PetService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pet")
public class PetController {

	@Resource
	private PetService petService;
	
	@RequestMapping("/addpet")
	@ResponseBody
	public Map addPet(Pet pet){
		Map result = new HashMap();
		try{
			petService.addPet(pet);
			result.put("success", true);
			result.put("msg", "添加成功");
		}catch(Exception e){
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getPetsByMaster/{mId}")
	@ResponseBody
	public Map getPetsByMaster(@PathVariable Integer mId) {
		Map result = new HashMap();
		try {
			List<Pet> list = petService.getByMasterId(mId);
			result.put("success", true);
			result.put("petList", list);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getById/{petId}")
	@ResponseBody
	public Map getById(@PathVariable Integer petId) {
		Map result = new HashMap();
		try {
			Pet pet = petService.getByPetId(petId);
			result.put("success", true);
			result.put("pet", pet);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
