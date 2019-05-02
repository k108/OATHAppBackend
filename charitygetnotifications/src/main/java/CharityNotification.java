public class CharityNotification {
    String userName;
    String userEmailId;
    String userLat;
    String userLng;
    String userAddress;
    String userPhoneNumber;
    Boolean isCompletedByCharity;
    String item;
    String quantity;
    String transactionType;
    String currentStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserLat() {
        return userLat;
    }

    public void setUserLat(String userLat) {
        this.userLat = userLat;
    }

    public String getUserLng() {
        return userLng;
    }

    public void setUserLng(String userLng) {
        this.userLng = userLng;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Boolean getCompletedByCharity() {
        return isCompletedByCharity;
    }

    public void setCompletedByCharity(Boolean completedByCharity) {
        isCompletedByCharity = completedByCharity;
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

    public CharityNotification(String userName, String userEmailId, String userLat, String userLng, String userAddress, String userPhoneNumber, Boolean isCompletedByCharity, String item, String quantity, String transactionType, String currentStatus) {
        this.userName = userName;
        this.userEmailId = userEmailId;
        this.userLat = userLat;
        this.userLng = userLng;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.isCompletedByCharity = isCompletedByCharity;
        this.item = item;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.currentStatus = currentStatus;
    }
}
