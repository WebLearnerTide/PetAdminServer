package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PostMapper;
import cn.ctide.pet.Model.Post;
import cn.ctide.pet.Service.PostService;
import cn.ctide.pet.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Anker on 2017/3/17.
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public Map getHotPost(Page page) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List list = postMapper.getHotPost(new Date());
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                result.put("hotPostList", list);
                result.put("total", ((com.github.pagehelper.Page)list).getPages());
                result.put("page", ((com.github.pagehelper.Page)list).getPageNum());
                result.put("empty", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "获取失败！" + e.getMessage());
        }
        return result;
    }

    @Override
    public int addNewPost(Post post) {
        try {
            post.setpTime(new Date());
            return postMapper.insertSelective(post);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Map getMyPost(Page page, Integer mId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List list = postMapper.getMyPosts(mId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                result.put("myPostList", list);
                result.put("total", ((com.github.pagehelper.Page)list).getPages());
                result.put("page", ((com.github.pagehelper.Page)list).getPageNum());
                result.put("empty", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "获取失败！" + e.getMessage());
        }
        return result;
    }
}
