package example.classManager.service.serviceImp;

import example.classManager.Utils.ResponseSetting;
import example.classManager.dao.TeacherDao;
import example.classManager.entity.Class;
import example.classManager.entity.Course;
import example.classManager.entity.Teacher;
import example.classManager.service.TeacherService;
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
public class TeacherServiceImp implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    /**
     * @param request
     * @param httpServletResponse
     * @param teacher             通过json的方式提交Teacher实体类{t_id,t_name}
     * @desciption:
     * @return:
     * @time: 2020/9/24 15:09
     */
    @Override
    public void addTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (teacher == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            teacherDao.add(teacher);
            printWriter.println("添加教师成功！");
            System.out.println("添加教师" + teacherDao.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("添加教师失败！");
            System.out.println("添加教师" + teacher.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param kind     :指通过老师的某个属性来搜索满足条件的老师，kind的值域为:{t_id,all}
     * @param param    :老师某个属性的具体值，当kind=all的时候，param可以为任意值
     * @desciption:
     * @return: List<Teacher>类型的结果
     * @time: 2020/9/24 14:14
     */
    @Override
    public void findTeachersByKind(HttpServletRequest request, HttpServletResponse response, String kind, String param) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        List<Teacher> result = null;
        if (kind.equals("t_id")) {
            result = new ArrayList<>();
            result.add(teacherDao.getById(param));
        } else if (kind.equals("all")) {
            result = teacherDao.findAll();
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }

    /**
     * @param request
     * @param response
     * @param t_id
     * @desciption: 通过老师的id来找老师管理的班级
     * @return: Json格式的Class
     * @time: 2020/9/24 15:18
     */
    @Override
    public void getClassById(HttpServletRequest request, HttpServletResponse response, String t_id) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (t_id == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        Class result = null;
        try {
            result = teacherDao.getClassById(t_id);
            ResponseSetting.PrintJsonObject(printWriter,result);
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("查询班级失败！");
            System.out.println("查询班级失败！t_id = "+t_id);
        }
    }

    /**
     * @param request
     * @param response
     * @param t_id
     * @desciption: 通过老师的id来获取老师教的课程
     * @return: Json格式的List<Course>
     * @time: 2020/9/24 15:20
     */
    @Override
    public void getCoursesById(HttpServletRequest request, HttpServletResponse response, String t_id) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (t_id == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        List<Course> result = null;
        try {
            result = teacherDao.getCoursesById(t_id);
            ResponseSetting.PrintJsonObject(printWriter,result);
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("查询课程失败！");
            System.out.println("查询课程失败！t_id = "+t_id);
        }
    }

    /**
     * @param request
     * @param httpServletResponse
     * @param teacher             以json的格式提交教师信息
     * @desciption: 更新教师信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    @Override
    public void updateTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (teacher == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            teacherDao.update(teacher);
            printWriter.println("更新教师成功！");
            System.out.println("更新教师" + teacher.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("更新教师失败！");
            System.out.println("更新教师" + teacher.toString() + "成功！");
        }
    }

    /**
     * @param request
     * @param httpServletResponse
     * @param teacher             以json的格式提交教师信息
     * @desciption: 删除教师
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    @Override
    public void deleteTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (teacher == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            teacherDao.delete(teacher);
            printWriter.println("删除教师成功！");
            System.out.println("删除教师" + teacher.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("删除教师失败！");
            System.out.println("删除教师" + teacher.toString() + "成功！");
        }
    }
}
