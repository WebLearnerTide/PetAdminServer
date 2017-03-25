package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Post;
import cn.ctide.pet.Service.PostService;
import cn.ctide.pet.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/getPostDetail")
    @ResponseBody
    public Map getPostDetail(Page p, Integer pId) {
        return postService.getPostDetail(p, pId);
    }

    @RequestMapping("/getCollect")
    @ResponseBody
    public Map getCollect(Page p, Integer mId) {
        return postService.getCollectPost(p, mId);
    }

    @RequestMapping("/getBarPosts")
    @ResponseBody
    public Map getBarPosts(Integer barId, Page p) {
        return postService.getBarPost(p, barId);
    }

    @RequestMapping("/getBarTop")
    @ResponseBody
    public Map get(Integer barId) {
        Map result = new HashMap();
        try {
            List list = postService.getBarTopPost(barId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("empty", true);
                result.put("msg", "没有置顶帖");
            } else {
                result.put("topPost", list);
                result.put("empty", false);
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("empty", true);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
