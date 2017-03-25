package cn.ctide.pet.Service;

import cn.ctide.pet.Model.Reply;
import cn.ctide.pet.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/23.
 */
public interface ReplyService {
    void addReply(Reply reply) throws Exception;

    void doReadReply(Integer mId) throws Exception;

    Map getReply(Page page, Integer mId);

    Integer getReplyCount(Integer mId);
}
