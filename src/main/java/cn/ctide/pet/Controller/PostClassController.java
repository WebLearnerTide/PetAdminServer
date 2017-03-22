package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.PostClass;
import cn.ctide.pet.Service.PostClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/22.
 */
@Controller
@RequestMapping("/postClass")
public class PostClassController {

    @Resource
    private PostClassService postClassService;

    @RequestMapping("/getAllClass")
    @ResponseBody
    public Map getAllClass() {
        Map result = new HashMap();
        try {
            List<PostClass> list = postClassService.getPostClass();
            result.put("postClassList",list);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
