package example.classManager.entity;

public class Course {
    private String course_id;
    private String course_name;
    private String t_id;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public Course() {}

    public Course(String course_id, String course_name, String t_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", t_id='" + t_id + '\'' +
                '}';
    }
}
