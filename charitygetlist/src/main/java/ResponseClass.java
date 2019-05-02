import java.util.List;

public class ResponseClass {

    List<CharityPreview> result;

    public List<CharityPreview> getResult() {
        return result;
    }

    public void setResult(List<CharityPreview> result) {
        this.result = result;
    }

    public ResponseClass(List<CharityPreview> result) {
        this.result = result;
    }
}
