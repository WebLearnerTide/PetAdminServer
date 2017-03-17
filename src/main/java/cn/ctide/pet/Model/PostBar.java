package cn.ctide.pet.Model;

public class PostBar {
    private Integer barId;

    private String barName;

    private String barType;

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName == null ? null : barName.trim();
    }

    public String getBarType() {
        return barType;
    }

    public void setBarType(String barType) {
        this.barType = barType;
    }
}