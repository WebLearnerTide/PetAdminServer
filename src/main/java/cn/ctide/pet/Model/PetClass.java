package cn.ctide.pet.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PetClass {
    private Integer petcId;

    private String petcName;

    private Integer petcBuild;
    
    private String petcBuildName;

    public Integer getPetcId() {
        return petcId;
    }

    public void setPetcId(Integer petcId) {
        this.petcId = petcId;
    }

    public String getPetcName() {
        return petcName;
    }

    public void setPetcName(String petcName) {
        this.petcName = petcName == null ? null : petcName.trim();
    }

    public Integer getPetcBuild() {
        return petcBuild;
    }

    public void setPetcBuild(Integer petcBuild) {
        this.petcBuild = petcBuild;
    }

	public String getPetcBuildName() {
		return petcBuildName;
	}

	public void setPetcBuildName(String petcBuildName) {
		this.petcBuildName = petcBuildName;
	}
    
    
}