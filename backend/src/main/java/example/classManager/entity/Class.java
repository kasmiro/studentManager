package example.classManager.entity;

public class Class {
    private String class_id;
    private String class_name;
    private String t_id;

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public Class() {}

    public Class(String class_id, String class_name, String t_id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", t_id='" + t_id + '\'' +
                '}';
    }
}
