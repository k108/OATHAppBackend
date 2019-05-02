public class UserNotification {
    String charityName;
    String charityEmailId;
    String charityLat;
    String charityLng;
    String charityAddress;
    String charityPhoneNumber;
    Boolean isCompletedByUser;
    String item;
    String quantity;
    String transactionType;
    String currentStatus;

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCharityEmailId() {
        return charityEmailId;
    }

    public void setCharityEmailId(String charityEmailId) {
        this.charityEmailId = charityEmailId;
    }

    public String getCharityLat() {
        return charityLat;
    }

    public void setCharityLat(String charityLat) {
        this.charityLat = charityLat;
    }

    public String getCharityLng() {
        return charityLng;
    }

    public void setCharityLng(String charityLng) {
        this.charityLng = charityLng;
    }

    public String getCharityAddress() {
        return charityAddress;
    }

    public void setCharityAddress(String charityAddress) {
        this.charityAddress = charityAddress;
    }

    public String getCharityPhoneNumber() {
        return charityPhoneNumber;
    }

    public void setCharityPhoneNumber(String charityPhoneNumber) {
        this.charityPhoneNumber = charityPhoneNumber;
    }

    public Boolean getCompletedByUser() {
        return isCompletedByUser;
    }

    public void setCompletedByUser(Boolean completedByUser) {
        isCompletedByUser = completedByUser;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public UserNotification(String charityName, String charityEmailId, String charityLat, String charityLng, String charityAddress, String charityPhoneNumber, Boolean isCompletedByUser, String item, String quantity, String transactionType, String currentStatus) {
        this.charityName = charityName;
        this.charityEmailId = charityEmailId;
        this.charityLat = charityLat;
        this.charityLng = charityLng;
        this.charityAddress = charityAddress;
        this.charityPhoneNumber = charityPhoneNumber;
        this.isCompletedByUser = isCompletedByUser;
        this.item = item;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.currentStatus = currentStatus;
    }
}
