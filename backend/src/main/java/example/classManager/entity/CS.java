package example.classManager.entity;

public class CS {
    private String course_id;
    private String s_id;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public CS() {}

    public CS(String course_id, String s_id) {
        this.course_id = course_id;
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "CS{" +
                "course_id='" + course_id + '\'' +
                ", s_id='" + s_id + '\'' +
                '}';
    }
}
