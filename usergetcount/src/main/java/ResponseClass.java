public class ResponseClass {
    String userCount;
    Boolean result;

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public ResponseClass(Boolean result) {
        this.result = result;
    }

    public ResponseClass(String userCount) {
        this.userCount = userCount;
    }
}
