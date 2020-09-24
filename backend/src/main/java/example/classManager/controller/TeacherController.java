package example.classManager.controller;

import example.classManager.entity.Teacher;
import example.classManager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/24
 */
@Controller
@CrossOrigin
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/addTeacher")
    /**
     * @param teacher Teacher{t_id,t_name}
     * @desciption:
     * @return: message
     * @time: 2020/9/24 15:09
     */
    public void addTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        teacherService.addTeacher(request,httpServletResponse,teacher);
    }

    @GetMapping("/findTeachersByKind")
    /**
     * @param kind:指通过老师的某个属性来搜索满足条件的老师，kind的值域为:{t_id,all}
     * @param param:老师某个属性的具体值，当kind=all的时候，param可以为任意值,但不能为null
     * @desciption:
     * @return: List<Teacher>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findTeachersByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param",required = false) String param) throws IOException {
        teacherService.findTeachersByKind(request,response,kind,param);
    }

    @PostMapping("/findClassByTeacherId")
    /**
     * @param t_id
     * @desciption: 通过老师的id来找老师管理的班级
     * @return: Json格式的Class
     * @time: 2020/9/24 15:18
     */
    public void getClassById(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "t_id") String t_id) throws IOException {
        teacherService.getClassById(request,response,t_id);
    }


    @PostMapping("/findCourseByTeacherId")
    /**
     * @param t_id
     * @desciption: 通过老师的id来获取老师教的课程
     * @return: Json格式的List<Course>
     * @time: 2020/9/24 15:20
     */
    public void getCoursesById(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "t_id") String t_id) throws IOException {
        teacherService.getCoursesById(request,response,t_id);
    }

    @PostMapping("/updateTeacher")
    /**
     * @param teacher Teacher{t_id,t_name}
     * @desciption: 更新教师信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void updateTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        teacherService.updateTeacher(request,httpServletResponse,teacher);
    }

    @PostMapping("/deleteTeacher")
    /**
     * @param teacher Teacher{t_id,t_name}
     * @desciption: 删除教师
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void deleteTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        teacherService.deleteTeacher(request,httpServletResponse,teacher);
    }
}
