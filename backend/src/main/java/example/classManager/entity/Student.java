package example.classManager.entity;

public class Student {
    private String s_id;
    private String s_name;
    private String major;
    private String class_id;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public Student() {}

    public Student(String s_id, String s_name, String major, String class_id) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.major = major;
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", major='" + major + '\'' +
                ", class_id='" + class_id + '\'' +
                '}';
    }
}
