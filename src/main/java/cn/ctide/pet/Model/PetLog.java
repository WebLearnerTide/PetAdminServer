package cn.ctide.pet.Model;

import java.util.Date;

public class PetLog {
    private String plogCode;

    private Integer petId;

    private String plogTitle;

    private String plogContent;

    private Date plogTime;

    public String getPlogCode() {
        return plogCode;
    }

    public void setPlogCode(String plogCode) {
        this.plogCode = plogCode == null ? null : plogCode.trim();
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPlogTitle() {
        return plogTitle;
    }

    public void setPlogTitle(String plogTitle) {
        this.plogTitle = plogTitle == null ? null : plogTitle.trim();
    }

    public String getPlogContent() {
        return plogContent;
    }

    public void setPlogContent(String plogContent) {
        this.plogContent = plogContent == null ? null : plogContent.trim();
    }

    public Date getPlogTime() {
        return plogTime;
    }

    public void setPlogTime(Date plogTime) {
        this.plogTime = plogTime;
    }
}