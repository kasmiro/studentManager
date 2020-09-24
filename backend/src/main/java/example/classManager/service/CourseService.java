package example.classManager.service;

import example.classManager.entity.Class;
import example.classManager.entity.Course;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/24
 */
public interface CourseService {
    /**
     * @desciption:
     * 添加课程，返回添加成功或失败的信息
     * @param course : 通过json的方式提交 Course{c_id,c_name,t_id}
     * @return: 字符串形式的信息
     */
    public void addCourse(HttpServletRequest request, HttpServletResponse httpServletResponse, Course course) throws IOException;


    /**
     * @desciption:
     * @param kind:指通过课程的某个属性来搜索满足条件的班级列表，kind的值域为:{course_id,all}
     * @param param:课程某个属性的具体值 当kind=all时，param为任意非null值
     * @return: List<Course>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findCourseByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param")String param) throws IOException;


    /**
    * @desciption:
     * @param course_id
    * @return: List<CS>
    * @time: 2020/9/24 17:00
    */
    public void getCSById(HttpServletRequest request,HttpServletResponse response,String course_id);

    /**
     * @desciption: 更新课程信息
     * @param course 课程信息  Course{c_id,c_name,t_id}
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void updateCourse(HttpServletRequest request,HttpServletResponse response,Course course) throws IOException;


    /**
     * @desciption: 删除课程
     * @param course 课程信息  Course{c_id,c_name,t_id}
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void deleteCourse(HttpServletRequest request,HttpServletResponse response,Course course) throws IOException;
}
