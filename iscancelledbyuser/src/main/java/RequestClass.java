import com.amazonaws.services.dynamodbv2.xspec.S;

public class RequestClass {
    private String userEmailId;
    private String charityEmailId;
    private String item;
    private String quantity;
    private String cancelRemarksByUser;

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getCharityEmailId() {
        return charityEmailId;
    }

    public void setCharityEmailId(String charityEmailId) {
        this.charityEmailId = charityEmailId;
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

    public String getCancelRemarksByUser() {
        return cancelRemarksByUser;
    }

    public void setCancelRemarksByUser(String cancelRemarksByUser) {
        this.cancelRemarksByUser = cancelRemarksByUser;
    }
}
