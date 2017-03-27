package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PostMapper;
import cn.ctide.pet.Model.Post;
import cn.ctide.pet.Model.PostDetail;
import cn.ctide.pet.Model.PostResources;
import cn.ctide.pet.Service.PostResourcesService;
import cn.ctide.pet.Service.PostService;
import cn.ctide.pet.container.OSS;
import cn.ctide.pet.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Anker on 2017/3/17.
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostResourcesService postResourcesService;

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

    @Override
    public Map getPostDetail(Page page, Integer pId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List<PostDetail> list = postMapper.getPostDetail(pId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                PostDetail detail = list.get(0);
                List<PostResources> resources = postResourcesService.getResources(detail.getpId());
                if (null!=resources && resources.size()!=0) {
                    List<String> urls = new ArrayList<>();
                    for (PostResources p : resources) {
                        urls.add(OSS.INSTANCE.generateUrl(p.getResImg(), ""));
                    }
                    detail.setImgList(urls);
                }
                list.set(0, detail);
                result.put("total", ((com.github.pagehelper.Page)list).getPages());
                result.put("page", ((com.github.pagehelper.Page)list).getPageNum());
                result.put("empty", false);
                result.put("postDetail", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "获取失败！" + e.getMessage());
        }
        return result;
    }

    @Override
    public Map getCollectPost(Page page, Integer mId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List list = postMapper.getCollectPost(mId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                result.put("collectPosts", list);
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
    public Map getBarPost(Page page, Integer barId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List<Map> list = postMapper.getBarPost(barId, false);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("totalPage", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                ArrayList<Map> target = new ArrayList<>();
                for (Map map : list) {
                    String mImg = (String) map.get("mImg");
                    if (null!=mImg) {
                        mImg = OSS.INSTANCE.generateUrl(mImg, OSS.INSTANCE.USER_STYLE);
                    }
                    map.put("mImg", mImg);
                    target.add(map);
                }
                result.put("barPost", target);
                result.put("total", ((com.github.pagehelper.Page)list).getTotal());
                result.put("totalPage", ((com.github.pagehelper.Page)list).getPages());
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
    public List getBarTopPost(Integer barId) throws Exception {
        return postMapper.getBarPost(barId, true);
    }

    @Override
    public Integer getNextId() {
        return postMapper.getNextPostCode();
    }
}
