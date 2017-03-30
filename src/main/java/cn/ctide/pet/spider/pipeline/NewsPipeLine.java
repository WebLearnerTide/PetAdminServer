package cn.ctide.pet.spider.pipeline;

import cn.ctide.pet.Model.News;
import cn.ctide.pet.Service.NewsService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;

/**
 * Created by Anker on 2017/3/28.
 */
public class NewsPipeLine implements Pipeline {
    private NewsService newsService;

    public NewsPipeLine() {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        newsService = wac.getBean(NewsService.class);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        News news = (News) resultItems.get("news");
        if (null!=news) {
            newsService.addNews(news);
        }
    }
}
