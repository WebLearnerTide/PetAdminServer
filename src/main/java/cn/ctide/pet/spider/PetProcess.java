package cn.ctide.pet.spider;


import cn.ctide.pet.Model.News;
import cn.ctide.pet.spider.pipeline.NewsPipeLine;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anker on 2017/3/28.
 */
public class PetProcess implements PageProcessor {
    private Site site = Site.me().setDomain("news.boqii.com");
    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://news\\.boqii\\.com/dog/\\d+\\.html").all();
        page.addTargetRequests(links);
        News news = new News();
        news.setNewsTitle(page.getHtml().xpath("//div[@class='leftbox articlinfo']/h3").toString());
        news.setNewsContent(page.getHtml().$("div.articl_con").toString());
        if (StringUtils.isEmpty(news.getNewsTitle())) {
            page.setSkip(true);
        } else {
            news.setNewsTitle(news.getNewsTitle().replaceAll("<h3>", "").replaceAll("</h3>", "").replaceAll("_波奇网", "").trim());
            news.setNewsContent(news.getNewsContent().replaceAll("<div class=\"articl_con\">", "<div>"));
            page.putField("news", news);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
