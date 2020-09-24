package example.classManager.dao;



import example.classManager.entity.Class;
import example.classManager.entity.Course;
import example.classManager.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeacherDao {
    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Insert("insert into teacher(t_id, t_name) values (#{t_id}, #{t_name})")
    public void add(Teacher teacher);

    @Select("select * from class where t_id=#{t_id}")
    public Class getClassById(String t_id);

    @Select("select * from teacher where t_id=#{t_id}")
    public Teacher getById(String t_id);

    @Select("select * from course where t_id=#{t_id}")
    public List<Course> getCoursesById(String t_id);

    @Update("update teacher set t_name=#{t_name} where t_id=#{t_id}")
    public void update(Teacher teacher);

    @Delete("delete from teacher where t_id=#{t_id}")
    public void delete(Teacher teacher);
}
