import java.util.List;

public class UserNotifications {
    List<UserNotification> result;

    public List<UserNotification> getResult() {
        return result;
    }

    public void setResult(List<UserNotification> result) {
        this.result = result;
    }

    public UserNotifications(List<UserNotification> result) {
        this.result = result;
    }

}
