package example.classManager.controller;

import example.classManager.entity.Student;
import example.classManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/23
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudent")
    /**
     * @param student : student{s_id,s_name,major,class_id}
     * @desciption: 添加学生，返回添加成功或失败的信息
     * @return: 字符串形式的信息
     * @time: 2020/9/24 13:39
     */
    public void addStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException {
        studentService.addStudent(request,httpServletResponse,student);
    }


    @PostMapping(value = "/findStudentsByKind")
    /**
     * @param kind:指通过学生的某个属性来搜索满足条件的学生列表，kind的可选值有:{s_id,s_name,major,,class_name,class_id}
     * @param param:学生某个属性的具体值
     * @desciption:
     * @return: List<Student>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findStudentsByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param") String param) throws IOException {
        studentService.findStudentsByKind(request,response,kind,param);
    }


    @PostMapping(value = "/updateStudent")
    /**
     * @param student student{s_id,s_name,major,class_id}
     * @desciption: 更新学生信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void updateStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException {
        studentService.updateStudent(request,httpServletResponse,student);
    }


    @PostMapping(value = "/deleteStudent")
    /**
     * @param student student{s_id,s_name,major,class_id}
     * @desciption: 删除学生
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void deleteStudent(HttpServletRequest request, HttpServletResponse httpServletResponse,Student student) throws IOException {
        studentService.deleteStudent(request, httpServletResponse, student);
    }
}

