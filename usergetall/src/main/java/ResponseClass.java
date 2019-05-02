import com.amazonaws.services.dynamodbv2.document.Item;

public class ResponseClass {
    Boolean result;
    String name;
    String emailId;
    String lat;
    String lng;
    String address;
    String city;
    String pinCode;
    String gender;
    String phoneNumber;
    String dateOfBirth;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ResponseClass(Boolean result) {
        this.result = result;
    }

    public ResponseClass(String name, String emailId, String lat, String lng, String address, String city, String pinCode, String gender, String phoneNumber, String dateOfBirth) {
        this.name = name;
        this.emailId = emailId;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
