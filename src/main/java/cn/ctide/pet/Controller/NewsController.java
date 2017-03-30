package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.News;
import cn.ctide.pet.Service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/29.
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @RequestMapping("/list")
    @ResponseBody
    public Map getList(Integer mId) {
        Map result = new HashMap();
        List<News> list = newsService.getRandomList(mId);
        result.put("success", true);
        result.put("list", list);
        return result;
    }

    @RequestMapping("/getByPetClass")
    @ResponseBody
    public Map getByPetClass(Integer petcId) {
        Map result = new HashMap();
        List<News> list = newsService.getRandomByPet(petcId);
        if (null!=list) {
            Collections.shuffle(list);
        }
        result.put("success", true);
        result.put("list", list);
        return result;
    }

    @RequestMapping("/getDetail")
    @ResponseBody
    public Map getDetail(Integer newsId) {
        Map result = new HashMap();
        News news = newsService.getNewsDetail(newsId);
        result.put("success", true);
        result.put("news", news);
        return result;
    }
}
