package model;

public class ModelExceptions {
    boolean status;
    int code;

    public ModelExceptions(boolean status, int code) {
        this.status = status;
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
