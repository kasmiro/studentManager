package example.classManager.dao;



import example.classManager.entity.CS;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CSDao {
    @Insert("insert into cs(course_id, s_id) values (#{course_id}, #{s_id})")
    public void add(CS cs);

    @Select("select * from cs where s_id=#{s_id}")
    public List<CS> getByStudentId(String s_id);

    @Select("select * from cs where course_id=#{course_id}")
    List<CS> findCSById(String course_id);

    @Delete("delete from course where course_id=#{course_id} and s_id=#{s_id}")
    public void delete(CS cs);
}
