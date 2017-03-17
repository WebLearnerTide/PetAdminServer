package cn.ctide.pet.Controller;

import cn.ctide.pet.Service.PostService;
import cn.ctide.pet.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
}
