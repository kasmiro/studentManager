package example.classManager.service.serviceImp;

import example.classManager.Utils.ResponseSetting;
import example.classManager.dao.StudentDao;
import example.classManager.entity.Student;
import example.classManager.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
public class StudentServiceImp implements StudentService {

    /**
     * @desciption: 添加学生，返回添加成功或失败的信息
     * @return:
     * @time: 2020/9/24 13:39
     */
    @Value("#{studentDao}")
    StudentDao studentDao;

    @Override
    public void addStudent(HttpServletRequest request, HttpServletResponse response, @RequestBody Student student) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (student == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            studentDao.add(student);
            printWriter.println("添加学生成功！");
            System.out.println("添加学生" + student.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("添加学生失败！");
            System.out.println("添加学生" + student.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param kind     :指通过学生的某个属性来搜索满足条件的学生列表，kind的值域为:{s_id,s_name,major,,class_name,class_id,all}
     * @param param    :学生某个属性的具体值
     *                 当kind = all, param !=null的时候返回所有学生
     * @return: List<Student>类型的结果
     * @time: 2020/9/24 14:14
     */
    @Override
    public void findStudentsByKind(HttpServletRequest request, HttpServletResponse response, String kind, String param) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        List<Student> result = null;
        if (kind.equals("s_id")) {
            result = new ArrayList<>();
            result.add(studentDao.getById(param));
        } else if (kind.equals("s_name")){
            result = studentDao.getByName(param);
        }else if(kind.equals("major")){
            result = studentDao.getByMajor(param);
        }else if(kind.equals("class_id")){
            result = studentDao.getByClassId(param);
        }else if(kind.equals("class_name")){
            result = studentDao.getByClassName(param);
        }else if(kind.equals("all")){
            result = studentDao.findAll();
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }

    /**
     * @param request
     * @param httpServletResponse
     * @param student             以json的格式提交学生信息
     * @desciption: 更新学生信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    @Override
    public void updateStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (student == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            studentDao.update(student);
            printWriter.println("更新学生成功！");
            System.out.println("更新学生" + student.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("更新学生失败！");
            System.out.println("更新学生" + student.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param httpServletResponse
     * @param student             以json的格式提交学生信息
     * @desciption: 删除学生
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    @Override
    public void deleteStudent(HttpServletRequest request, HttpServletResponse httpServletResponse, Student student) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (student == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            studentDao.delete(student);
            printWriter.println("删除学生成功！");
            System.out.println("删除学生" + student.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("删除学生失败！");
            System.out.println("删除学生" + student.toString() + "失败！");
        }
    }
}
