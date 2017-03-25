package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.ReplyMapper;
import cn.ctide.pet.Model.Reply;
import cn.ctide.pet.Service.ReplyService;
import cn.ctide.pet.util.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/23.
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper mapper;

    @Override
    public void addReply(Reply reply) throws Exception {
        try {
            int count = mapper.insertSelective(reply);
            if (count!=1) {
                throw new Exception("评论失败");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void doReadReply(Integer mId) throws Exception {
        mapper.readReply(mId);
    }

    @Override
    public Map getReply(Page page, Integer mId) {
        Map result = new HashMap();
        if (null==page) {
            page = new Page();
        }
        PageHelper.startPage(page.getPage(), page.getPageSize(), true);
        try {
            List list = mapper.getReply(mId);
            result.put("success", true);
            if (null==list || list.size()==0) {
                result.put("total", 0);
                result.put("page", 1);
                result.put("empty", true);
            } else {
                result.put("replyList", list);
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
    public Integer getReplyCount(Integer mId) {
        return mapper.getReplyCount(mId);
    }
}
