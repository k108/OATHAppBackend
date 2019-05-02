import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FillOnGoingTransaction {
    private String id;
    private String userName;
    private String userEmailId;
    private String userAddress;
    private String userLat;
    private String userLng;
    private String userPhoneNumber;
    private String charityName;
    private String charityEmailId;
    private String charityLat;
    private String charityLng;
    private String charityAddress;
    private String charityPhoneNumber;
    private String item;
    private String quantity;
    private Boolean isCompletedByUser = false;
    private Boolean isCompletedByCharity = false;
    private Boolean isCancelledByUser = false;
    private String cancelRemarksByUser = "NA";

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date dateObject = new Date();

    private String lastUpdateDate = dateFormat.format(dateObject);
    private String transactionType;
    private String currentStatus = "Pending By Both";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

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

    public Boolean getCompletedByUser() {
        return isCompletedByUser;
    }

    public void setCompletedByUser(Boolean completedByUser) {
        isCompletedByUser = completedByUser;
    }

    public Boolean getCompletedByCharity() {
        return isCompletedByCharity;
    }

    public void setCompletedByCharity(Boolean completedByCharity) {
        isCompletedByCharity = completedByCharity;
    }

    public Boolean getCancelledByUser() {
        return isCancelledByUser;
    }

    public void setCancelledByUser(Boolean cancelledByUser) {
        isCancelledByUser = cancelledByUser;
    }

    public String getCancelRemarksByUser() {
        return cancelRemarksByUser;
    }

    public void setCancelRemarksByUser(String cancelRemarksByUser) {
        this.cancelRemarksByUser = cancelRemarksByUser;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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
}
