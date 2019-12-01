package My;

public class Result {
    private Boolean bool;
    private String message;

    public Result(Boolean bool, String message) {
        this.bool = bool;
        this.message = message;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
