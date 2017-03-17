package cn.ctide.pet.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Service.MasterService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private MasterService masterService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Map login(Master master) {
		Map result = new HashMap();
		try {
			master.setmScore(null);
			Master m = masterService.getMasterByMaster(master);
			result.put("success", true);
			result.put("msg", "登录成功");
			result.put("master", m);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Map register(Master master){
		Map result = new HashMap();
		try{
			masterService.addMaster(master);
			result.put("success", true);
			result.put("msg", "注册成功");
		}catch(Exception e){
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/getByMId")
	@ResponseBody
	public Map getByMId(Integer mId) {
		Map result = new HashMap();
		try {
			Master m = masterService.getByPrimaryKey(mId);
			result.put("success", true);
			result.put("master", m);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/sign")
	@ResponseBody
	public Map doSign(Integer mId) {
		Map result = new HashMap();
		Master master = masterService.updateSign(mId);
		result.put("success", true);
		result.put("master", master);
		return result;
	}
}
