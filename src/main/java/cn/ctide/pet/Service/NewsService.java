package cn.ctide.pet.Service;

import cn.ctide.pet.Model.News;

import java.util.List;

/**
 * Created by Anker on 2017/3/28.
 */
public interface NewsService {
    void addNews(News news);

    List<News> getRandomList(Integer mId);

    List<News> getRandomByPet(Integer petId);

    News getNewsDetail(Integer newsId);
}
