package cn.ctide.pet.Model;

import java.util.Date;

public class MPCollect extends MPCollectKey {
    private Date collectTime;

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}