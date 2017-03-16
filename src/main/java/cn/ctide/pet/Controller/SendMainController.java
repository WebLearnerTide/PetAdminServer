package cn.ctide.pet.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Service.MasterService;
import cn.ctide.pet.util.EmailSender;

@Controller
@RequestMapping("/sendMail/")
public class SendMainController {
	
	@Autowired
	private EmailSender sender;

	@Autowired
    private MasterService masterService;
	
	@RequestMapping("reset")
	@ResponseBody
	public Map reset(String email) {
		Map result = new HashMap();
		try {
            Master master = masterService.getByEmail(email);
            if (null != master) {
                String resetCode = sender.sendResetCode(email);
                result.put("msg", "成功！");
                result.put("success", true);
                result.put("resetCode", resetCode);
            } else {
                // todo 用户不存在
            }
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "失败！" + e.getMessage());
			result.put("success", false);
		}
		return result;
	}

}
