package cn.ctide.pet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ctide.pet.Model.PetClass;
import cn.ctide.pet.Model.PostClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Service.PetClassService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/petClass")
public class PetClassController {
	
	@Resource
	private PetClassService petClassService;
	
	@RequestMapping("/getBuild")
	@ResponseBody
	public Map getBuild() {
		Map result = new HashMap();
		try {
			List<PetClass> list = petClassService.getBuilds();
			result.put("success", true);
			result.put("buildList", list);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getByBuild")
	@ResponseBody
	public Map getByBuild(PetClass petClass) {
		Map result = new HashMap();
		try {
			List<PetClass> list = petClassService.getPetClassList(petClass);
			result.put("success", true);
			result.put("classList", list);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/getByMaster")
	@ResponseBody
	public Map getByMaster(Integer mId) {
		Map result = new HashMap();
		try {
			List<PetClass> list = petClassService.getMasterClass(mId);
			result.put("petClass",list);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
