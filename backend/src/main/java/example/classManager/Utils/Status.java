package example.classManager.Utils;

/**
 * Created on 2020/9/24
 * enum枚举类,相当于定义了一些自定义类型的static final变量供直接调用
 */
public enum Status {
    SEND_SUCCESS(1,"发送成功"),
    SEND_FAILED(0,"发送失败");
    private int code;
    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Status.SEND_SUCCESS.code);
        System.out.println(Status.SEND_SUCCESS);
    }
}
