import java.io.Serializable;

public class CharityPreview implements Serializable {
    String name;
    String emailId;
    String type;
    String bannerImage;
    String numberOfResidents;
    String distance;
    Boolean isVerified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(String numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        isVerified = isVerified;
    }

    public CharityPreview(String name, String emailId, String type, String bannerImage, String numberOfResidents, String distance, Boolean isVerified) {
        this.name = name;
        this.emailId = emailId;
        this.type = type;
        this.bannerImage = bannerImage;
        this.numberOfResidents = numberOfResidents;
        this.distance = distance;
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        return "{\n\"name\":"+name+",\n\"emailId\":"+emailId+",\n\"type\":"+type+",\n\"bannerImage\":"+bannerImage+",\n\"numberOfResidents\":"+numberOfResidents+",\n\"distance\":"+distance+",\n\"isVerified\":"+isVerified+"\n}";
    }
}
