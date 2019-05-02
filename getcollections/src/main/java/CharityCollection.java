import java.io.Serializable;

public class CharityCollection implements Serializable{
    String userName;
    String item;
    String quantity;
    String lastUpdateDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public CharityCollection(String userName, String item, String quantity, String lastUpdateDate) {
        this.userName = userName;
        this.item = item;
        this.quantity = quantity;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "{\n\"userName\":"+userName+",\n\"item\":"+item+",\n\"quantity\":"+quantity+",\n\"lastUpdateDate\":"+lastUpdateDate+"\n}";
    }
}
