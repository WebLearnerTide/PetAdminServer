package cn.ctide.pet.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Pet {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
    private Integer petId;

    private Integer mId;

    private Integer petcId;

    private String petName;

    private Date petDate;

    private Date petBirth;

    private Integer petGender;

    private String petColor;

    private String petPhoto;
    
    private String petBirthStr;
    
    private String petDateStr;
    
    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getPetcId() {
        return petcId;
    }

    public void setPetcId(Integer petcId) {
        this.petcId = petcId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public Date getPetDate() {
        return petDate;
    }

    public void setPetDate(Date petDate) {
        this.petDate = petDate;
    }

    public Date getPetBirth() {
        return petBirth;
    }

    public void setPetBirth(Date petBirth) {
        this.petBirth = petBirth;
    }

    public Integer getPetGender() {
        return petGender;
    }

    public void setPetGender(Integer petGender) {
        this.petGender = petGender;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor == null ? null : petColor.trim();
    }

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto == null ? null : petPhoto.trim();
    }

	public String getPetBirthStr() {
		return petBirthStr;
	}

	public void setPetBirthStr(String petBirthStr) {
		this.petBirthStr = petBirthStr;
		try {
			petBirth = sdf.parse(petBirthStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			petBirth = new Date();
		}
	}

	public String getPetDateStr() {
		return petDateStr;
	}

	public void setPetDateStr(String petDateStr) {
		this.petDateStr = petDateStr;
		try {
			petDate = sdf.parse(petDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			petDate = new Date();
		}
	}

}