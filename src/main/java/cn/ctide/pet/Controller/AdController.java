package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Ad;
import cn.ctide.pet.Service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/27.
 */
@Controller
@RequestMapping("/ad")
public class AdController {
    @Resource
    private AdService adService;

    @RequestMapping("/latest")
    @ResponseBody
    public Map latest() {
        Map result = new HashMap();
        try {
            List<Ad> list = adService.getAdList();
            result.put("success", true);
            result.put("latest", list);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }
}
