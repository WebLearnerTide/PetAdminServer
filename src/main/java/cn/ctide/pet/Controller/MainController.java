package cn.ctide.pet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Service.MasterService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class MainController {

	@Resource
	private MasterService masterService;
	
	@RequestMapping
	public String index() {
		return "index";
	}
	
	@RequestMapping("/1")
	@ResponseBody
	public Master test() {
		return masterService.getMaster();
	}
}
