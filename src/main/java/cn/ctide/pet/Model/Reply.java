package cn.ctide.pet.Model;

import java.util.Date;

public class Reply {
    private Integer rId;

    private Integer mId;

    private Integer pId;

    private String rContent;

    private Date rTime;

    private Integer rIded;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent == null ? null : rContent.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrIded() {
        return rIded;
    }

    public void setrIded(Integer rIded) {
        this.rIded = rIded;
    }
}