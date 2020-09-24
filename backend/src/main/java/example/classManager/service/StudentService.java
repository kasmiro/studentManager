package example.classManager.service;

import example.classManager.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 2020/9/24
 */
public interface StudentService {


    /**
    * @desciption:
     * 添加学生，返回添加成功或失败的信息
     * @param student : 通过json的方式提交
    * @return: 字符串形式的信息
    * @time: 2020/9/24 13:39
    */
    public void addStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException;


    /**
    * @desciption:
     * @param kind:指通过学生的某个属性来搜索满足条件的学生列表，kind的值域为:{s_id,s_name,major,,class_name,class_id}
     * @param param:学生某个属性的具体值
    * @return: List<Student>类型的结果
    * @time: 2020/9/24 14:14
    */
    public void findStudentsByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind,@RequestParam(name = "param")String param) throws IOException;


    /**
    * @desciption: 更新学生信息
     * @param student 以json的格式提交学生信息
    * @return: 返回成功与否的结果
    * @time: 2020/9/24 14:47
    */
    public void updateStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException;


    /**
     * @desciption: 删除学生
     * @param student 以json的格式提交学生信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void deleteStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException;
}
