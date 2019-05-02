import java.io.Serializable;

public class UserDonations implements Serializable {
    String charityName;
    String item;
    String lastUpdateDate;

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public UserDonations(String charityName, String item, String lastUpdateDate) {
        this.charityName = charityName;
        this.item = item;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "{\n\"charityName\":"+charityName+",\n\"item\":"+item+",\n\"lastUpdateDate\":"+lastUpdateDate+"\n}";
    }
}
