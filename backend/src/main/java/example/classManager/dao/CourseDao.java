package example.classManager.dao;

import example.classManager.entity.CS;
import example.classManager.entity.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CourseDao {



    @Insert("insert into course(course_id, course_name, t_id) values (#{course_id}, #{course_name}, #{t_id})")
    void add(Course course);

    @Select("select * from course where course_id=#{course_id}")
    Course findById(String course_id);

    @Select("select * from course")
    List<Course> findAll();

    @Select("select * from course where t_id=#{t_id}")
    List<Course> findByTeacherId(String t_id);


    @Update("update course set course_name=#{course_name}, t_id=#{t_id} where course_id=#{course_id}")
    void update(Course course);

    @Delete("delete from course where course_id=#{course_id}")
    void delete(Course course);
}
