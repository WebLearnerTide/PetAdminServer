package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.ReplyMapper;
import cn.ctide.pet.Model.Reply;
import cn.ctide.pet.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
