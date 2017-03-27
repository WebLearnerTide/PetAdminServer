package cn.ctide.pet.Model;

public class Album {
    private Integer photoId;

    private Integer petId;

    private String photoUrl;

    private String minUrl;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getMinUrl() {
        return minUrl;
    }

    public void setMinUrl(String minUrl) {
        this.minUrl = minUrl;
    }
}