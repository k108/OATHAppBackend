public class ResponseClass {
    Boolean result;
    String name;
    String emailId;
    String lat;
    String lng;
    String address;
    String city;
    String pinCode;
    String phoneNumber;
    String type;
    String registerationNumber;
    String dateOfEstablishment;
    String password;
    String registerationCertificateImage;
    String bannerImage;
    String image1;
    String pickupRadius;
    String numberOfResidents;
    String residentGender;
    Boolean isVerified;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }

    public String getdateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setdateOfEstablishment(String dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterationCertificateImage() {
        return registerationCertificateImage;
    }

    public void setRegisterationCertificateImage(String registerationCertificateImage) {
        this.registerationCertificateImage = registerationCertificateImage;
    }

    public String getbannerImage() {
        return bannerImage;
    }

    public void setbannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getimage1() {
        return image1;
    }

    public void setimage1(String image1) {
        this.image1 = image1;
    }

    public String getPickupRadius() {
        return pickupRadius;
    }

    public void setPickupRadius(String pickupRadius) {
        this.pickupRadius = pickupRadius;
    }

    public String getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(String numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    public String getResidentGender() {
        return residentGender;
    }

    public void setResidentGender(String residentGender) {
        this.residentGender = residentGender;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        isVerified = isVerified;
    }

    public ResponseClass(Boolean result) {
        this.result = result;
    }

    public ResponseClass(String name, String emailId, String lat, String lng, String address, String city, String pinCode, String phoneNumber, String type, String registerationNumber, String dateOfEstablishment, String password, String registerationCertificateImage, String bannerImage, String image1, String pickupRadius, String numberOfResidents, String residentGender, Boolean isVerified) {
        this.name = name;
        this.emailId = emailId;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.registerationNumber = registerationNumber;
        this.dateOfEstablishment = dateOfEstablishment;
        this.password = password;
        this.registerationCertificateImage = registerationCertificateImage;
        this.bannerImage = bannerImage;
        this.image1 = image1;
        this.pickupRadius = pickupRadius;
        this.numberOfResidents = numberOfResidents;
        this.residentGender = residentGender;
        this.isVerified = isVerified;
    }
}
