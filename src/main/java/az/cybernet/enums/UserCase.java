package az.cybernet.enums;

public enum UserCase {
    USER_NOT_FOUND("User not found");
    private  String message;


    UserCase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
