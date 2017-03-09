package cn.ctide.pet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Model.Petclass;
import cn.ctide.pet.Service.PetclassService;

@Controller
@RequestMapping("/petClass")
public class PetClassController {
	
	@Autowired
	private PetclassService petclassService;
	
	@RequestMapping("/getBuild")
	@ResponseBody
	public Map getBuild() {
		Map result = new HashMap();
		try {
			List<Petclass> list = petclassService.getBuilds();
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
	public Map getByBuild(Petclass petclass) {
		Map result = new HashMap();
		try {
			List<Petclass> list = petclassService.getPetclassList(petclass);
			result.put("success", true);
			result.put("classList", list);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

}
