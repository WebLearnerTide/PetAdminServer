package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.News;
import cn.ctide.pet.Service.NewsService;
import cn.ctide.pet.spider.PetProcess;
import cn.ctide.pet.spider.pipeline.NewsPipeLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

	@Resource
	private NewsService newsService;

	@RequestMapping
	public String index() {

		return "index";
	}

	@RequestMapping("start")
	@ResponseBody
	public Map start() {
		Spider.create(new PetProcess()).addUrl("http://news.boqii.com/dog/")
				.addPipeline(new NewsPipeLine()).addPipeline(new FilePipeline("/data.txt")).thread(100).runAsync();
		return null;
	}

	@RequestMapping("/news")
	@ResponseBody
	public Map insert(News news) {
		newsService.addNews(news);
		return null;
	}
	
}
