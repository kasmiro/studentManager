package example.classManager.dao;


import example.classManager.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface StudentDao {

    @Insert("insert into student(s_id, s_name, major, class_id) values (#{s_id}, #{s_name}, #{major}, #{class_id})")
    void add(Student student);

    @Select("select * from student where s_id=#{s_id}")
    Student getById(String s_id);

    @Select("select * from student")
    List<Student> findAll();

    @Select("select * from student where s_name like #{s_name}")
    List<Student> getByName(String s_name);

    @Select("select * from student where major like #{major}")
    List<Student> getByMajor(String major);

    @Select("select student.s_id, student.s_name, student.major, student.class_id " +
            "from student, class " +
            "where student.class_id=class.class_id and class.class_name like #{class_name}")
    List<Student> getByClassName(String class_name);

    @Select("select * from student where class_id=#{class_id}")
    List<Student> getByClassId(String class_id);

    @Update("update student set s_name=#{s_name}, major=#{major}, class_id=#{class_id} where s_id=#{s_id}")
    void update(Student student);

    @Delete("delete from student where s_id=#{s_id}")
    void delete(Student student);
}
