package cn.ctide.pet.Model;

public class PostResources {
    private Integer resId;

    private Integer pId;

    private String resImg;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getResImg() {
        return resImg;
    }

    public void setResImg(String resImg) {
        this.resImg = resImg == null ? null : resImg.trim();
    }
}