package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.FollowKey;
import cn.ctide.pet.Service.FollowService;
import cn.ctide.pet.Service.PostBarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/17.
 */
@Controller
@RequestMapping("/postBar")
public class PostBarController {
    @Resource
    private PostBarService postBarService;
    @Resource
    private FollowService followService;

    @RequestMapping("/unFollow")
    @ResponseBody
    public Map getUnFollowBar(Integer mId) {
        Map result = new HashMap();
        try {
            List list = postBarService.getPostBarList(mId, false);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("empty", true);
            } else {
                result.put("empty", false);
                result.put("barList", list);
            }
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("empty", true);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/follow")
    @ResponseBody
    public Map getFollowBar(Integer mId) {
        Map result = new HashMap();
        try {
            List list = postBarService.getPostBarList(mId, true);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("empty", true);
            } else {
                result.put("empty", false);
                result.put("barList", list);
            }
            result.put("msg", "获取成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("empty", true);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/addFollow")
    @ResponseBody
    public Map addFollow(FollowKey follow) {
        Map result = new HashMap();
        try {
            followService.addFollow(follow);
            result.put("success", true);
            result.put("msg", "添加成功！");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
