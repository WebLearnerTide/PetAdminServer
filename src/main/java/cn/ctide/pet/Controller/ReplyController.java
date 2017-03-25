package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Reply;
import cn.ctide.pet.Service.ReplyService;
import cn.ctide.pet.util.Page;
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
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @RequestMapping("/add")
    @ResponseBody
    public Map addReply(Reply reply) {
        Map result = new HashMap();

        try {
            replyService.addReply(reply);
            result.put("success", true);
        } catch (Exception e) {
//            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }

        return result;
    }

    @RequestMapping("/getReply")
    @ResponseBody
    public Map getReply(Page p, Integer mId) {
        return replyService.getReply(p, mId);
    }

    @RequestMapping("/getReplyCount")
    @ResponseBody
    public Map getReplyCount(Integer mId) {
        Map result = new HashMap();
        Integer count = replyService.getReplyCount(mId);
        result.put("count", count);
        return result;
    }

    @RequestMapping("/readReply")
    @ResponseBody
    public Map readReply(Integer mId) {
        Map result = new HashMap();
        try {
            replyService.doReadReply(mId);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
