import java.util.List;

public class Donation {
    List<UserDonations> result;

    public List<UserDonations> getResult() {
        return result;
    }

    public void setResult(List<UserDonations> result) {
        this.result = result;
    }

    public Donation(List<UserDonations> result) {
        this.result = result;
    }
}
