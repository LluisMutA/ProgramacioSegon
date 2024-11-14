package errorhandler;

public enum ErrorCodes {
    OK(0, "All OK"),                           //ALL OK
    SHORTPASS(1, "This password is to short"), //PASSWORD TO SHORT
    LONGPASS(2, "This password is to long"),   //PASSWORD TO BIG
    USEREXIST(3, "The user already exist");    //USER ALREADY EXISTS
    private String status;
    private int code;

    private ErrorCodes(int code, String status){
        this.code = code;
        this.status = status;

    }
    public String getStatus() {
        return status;
    }
    public int getCode() {
        return code;
    }


}
