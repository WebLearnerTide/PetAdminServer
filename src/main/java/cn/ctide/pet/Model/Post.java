package cn.ctide.pet.Model;

import java.util.Date;

public class Post {
    private Integer pId;

    private Integer pcId;

    private Integer mId;

    private String pTitle;

    private String pContent;

    private Date pTime;

    private Integer barId;

    private Boolean isTop;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getPcId() {
        return pcId;
    }

    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle == null ? null : pTitle.trim();
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent == null ? null : pContent.trim();
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }
}