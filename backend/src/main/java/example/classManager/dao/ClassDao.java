package example.classManager.dao;



import example.classManager.entity.Class;
import example.classManager.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ClassDao {

    @Select("select * from class")
    List<Class> findAll();

    @Select("insert into class(class_id, class_name, t_id) values (#{class_id}, #{class_name}, #{t_id})")
    void add(Class c);

    @Select("select * from class where class_id=#{class_id}")
    Class getById(String class_id);

    @Select("select * from class where class_name=#{class_name}")
    List<Class> getByName(String class_name);

    @Select("select * from student where class_id=#{class_id}")
    List<Student> getStudentsById(String class_id);

    @Update("update class set class_name=#{class_name}, t_id=#{t_id} where class_id=#{class_id}")
    void update(Class c);

    @Delete("delete from class where class_id=#{class_id}")
    void delete(Class c);
}
