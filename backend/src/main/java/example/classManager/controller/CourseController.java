package example.classManager.controller;

import example.classManager.entity.Course;
import example.classManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/24
 */
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    /**
     * @param course : Course{course_id,course_name,t_id}
     * @desciption: 添加课程，返回添加成功或失败的信息
     * @return: 字符串形式的信息
     */
    public void addCourse(HttpServletRequest request, HttpServletResponse httpServletResponse, Course course) throws IOException {
        courseService.addCourse(request,httpServletResponse,course);
    }

    @PostMapping("/findCourseByKind")
    /**
     * @param kind:指通过课程的某个属性来搜索满足条件的班级列表，kind的值域为:{course_id,all}
     * @param param:课程某个属性的具体值                                     当kind=all时，param为任意非null值
     * @desciption:
     * @return: List<Course>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findCourseByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param") String param) throws IOException {
        courseService.findCourseByKind(request,response,kind,param);
    }

    @PostMapping("/findCdByCourseId")
    /**
     * @param course_id
     * @desciption:
     * @return: List<CS>
     * @time: 2020/9/24 17:00
     */
    public void getCSById(HttpServletRequest request, HttpServletResponse response, String course_id) {
        courseService.getCSById(request,response,course_id);
    }

    @PostMapping("/updateCourse")
    /**
     * @param course 课程信息  Course{c_id,c_name,t_id}
     * @desciption: 更新课程信息
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void updateCourse(HttpServletRequest request, HttpServletResponse response, Course course) throws IOException {
        courseService.updateCourse(request,response,course);
    }

    @PostMapping("/deleteCourse")
    /**
     * @param course 课程信息  Course{c_id,c_name,t_id}
     * @desciption: 删除课程
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void deleteCourse(HttpServletRequest request, HttpServletResponse response, Course course) throws IOException {
        courseService.deleteCourse(request,response,course);
    }

}
