package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Post;
import cn.ctide.pet.Service.PostService;
import cn.ctide.pet.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anker on 2017/3/17.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @RequestMapping("/hot")
    @ResponseBody
    public Map getHotPosts(Page page) {
        return postService.getHotPost(page);
    }

    @RequestMapping("/addPost")
    @ResponseBody
    public Map addPost(Post post) {
        Map result = new HashMap();
        try {
            int count = postService.addNewPost(post);
            if (count==1) {
                result.put("success", true);
            } else {
                result.put("seuccess", false);
                result.put("msg", "添加失败");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/myPosts")
    @ResponseBody
    public Map getMyPosts(Page page, Integer mId) {
        return postService.getMyPost(page, mId);
    }
}
