package cn.ctide.pet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by Anker on 2017/3/23.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDetail {
    private Integer pId;

    private Integer pcId;

    private Integer mId;

    private String pTitle;

    private String pContent;

    private Date pTime;

    private Integer barId;

    private String mName;

    private String barName;

    private String pcName;

    private Integer rId;

    private Integer rIded;

    private String fContent;
    private Integer fId;
    private String fName;

    @JsonIgnore
    private Integer rowno;

    private String rowName;

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

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getrIded() {
        return rIded;
    }

    public void setrIded(Integer rIded) {
        this.rIded = rIded;
    }

    public Integer getRowno() {
        return rowno;
    }

    public void setRowno(Integer rowno) {
        this.rowno = rowno;
        this.rowName = 1==rowno?"楼主":rowno + "楼";
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
