package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.NewsMapper;
import cn.ctide.pet.Dao.PetClassMapper;
import cn.ctide.pet.Model.News;
import cn.ctide.pet.Model.PetClass;
import cn.ctide.pet.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anker on 2017/3/28.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private PetClassMapper petClassMapper;

    @Override
    public void addNews(News news) {
        newsMapper.insertSelective(news);
    }

    @Override
    public List<News> getRandomList(Integer mId) {
        List<PetClass> list = petClassMapper.getPetClass(mId);
        List<News> news = newsMapper.selectRandom(list);
        return news;
    }

    @Override
    public List<News> getRandomByPet(Integer petcId) {
        PetClass petClass = petClassMapper.selectByPrimaryKey(petcId);
        List<PetClass> list = new ArrayList<>();
        list.add(petClass);
        return newsMapper.selectRandom(list);
    }

    @Override
    public News getNewsDetail(Integer newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }
}
