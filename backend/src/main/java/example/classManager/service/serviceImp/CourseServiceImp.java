package example.classManager.service.serviceImp;

import example.classManager.Utils.ResponseSetting;
import example.classManager.dao.CourseDao;
import example.classManager.entity.Course;
import example.classManager.entity.Student;
import example.classManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/9/24
 */
@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseDao courseDao;

    /**
     * @param request
     * @param httpServletResponse
     * @param course              : 通过json的方式提交 Course{c_id,c_name,t_id}
     * @desciption: 添加课程，返回添加成功或失败的信息
     * @return: 字符串形式的信息
     */
    @Override
    public void addCourse(HttpServletRequest request, HttpServletResponse httpServletResponse, Course course) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (course == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            courseDao.add(course);
            printWriter.println("添加课程成功！");
            System.out.println("添加课程" + course.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("添加课程失败！");
            System.out.println("添加课程" + course.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param kind     :指通过课程的某个属性来搜索满足条件的班级列表，kind的值域为:{course_id,t_id,all}
     * @param param    :课程某个属性的具体值 当kind=all时，param为任意非null值
     * @desciption:
     * @return: List<Course>类型的结果
     * @time: 2020/9/24 14:14
     */
    @Override
    public void findCourseByKind(HttpServletRequest request, HttpServletResponse response, String kind, String param) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        List<Course> result = null;
        if (kind.equals("course_id")) {
            result = new ArrayList<>();
            result.add(courseDao.findById(param));
        } else if (kind.equals("t_id")){
            result = courseDao.findByTeacherId(param);
        }else if(kind.equals("all")){
            result = courseDao.findAll();
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }

    /**
     * @param request
     * @param response
     * @param course_id
     * @desciption:
     * @return: List<CS>
     * @time: 2020/9/24 17:00
     */
    @Override
    public void getCSById(HttpServletRequest request, HttpServletResponse response, String course_id) {

    }

    /**
     * @param request
     * @param response
     * @param course   课程信息  Course{c_id,c_name,t_id}
     * @desciption: 更新课程信息
     * @return:
     * @time: 2020/9/24 16:39
     */
    @Override
    public void updateCourse(HttpServletRequest request, HttpServletResponse response, Course course) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (course == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            courseDao.update(course);
            printWriter.println("更新课程信息成功！");
            System.out.println("更新课程"+course.toString()+"信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("更新课程信息失败！");
            System.out.println("更新课程"+course.toString()+"信息失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param course   课程信息  Course{c_id,c_name,t_id}
     * @desciption: 删除课程
     * @return:
     * @time: 2020/9/24 16:39
     */
    @Override
    public void deleteCourse(HttpServletRequest request, HttpServletResponse response, Course course) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (course == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            courseDao.delete(course);
            printWriter.println("删除课程成功！");
            System.out.println("删除课程" + course.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("删除课程失败！");
            System.out.println("删除课程" + course.toString() + "失败！");
        }
    }
}
