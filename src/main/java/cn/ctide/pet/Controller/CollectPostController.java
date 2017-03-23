package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.MPCollect;
import cn.ctide.pet.Model.MPCollectKey;
import cn.ctide.pet.Service.CollectPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anker on 2017/3/23.
 */
@Controller
@RequestMapping("/collect")
public class CollectPostController {
    @Resource
    private CollectPostService collectPostService;

    @RequestMapping("/add")
    @ResponseBody
    public Map addCollect(MPCollect collect) {
        Map result = new HashMap();
        try {
            collectPostService.addCollect(collect);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteCollect(MPCollectKey key) {
        Map result = new HashMap();
        try {
            collectPostService.deleteCollect(key);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/isCollect")
    @ResponseBody
    public Map isCollect(MPCollectKey key) {
        Map result = new HashMap();
        try {
            MPCollect collect = collectPostService.getCollectByKey(key);
            result.put("success", true);
            result.put("collect", collect);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
