package example.classManager.service.serviceImp;

import example.classManager.Utils.ResponseSetting;
import example.classManager.dao.ClassDao;
import example.classManager.entity.Class;
import example.classManager.entity.Student;
import example.classManager.service.ClassService;
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
public class ClassServiceImp implements ClassService {
    @Autowired
    ClassDao classDao;

    /**
     * @param request
     * @param httpServletResponse
     * @param c                   : 通过json的方式提交
     * @desciption: 添加班级，返回添加成功或失败的信息
     * @return: 字符串形式的信息
     */
    @Override
    public void addClass(HttpServletRequest request, HttpServletResponse httpServletResponse, Class c) throws IOException {
        httpServletResponse = ResponseSetting.responseSetJson(httpServletResponse);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(httpServletResponse);
        if (c == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            classDao.add(c);
            printWriter.println("添加班级成功！");
            System.out.println("添加班级" + c.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("添加学生失败！");
            System.out.println("添加班级" + c.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param kind     :指通过学生的某个属性来搜索满足条件的班级列表，kind的值域为:{class_id,class_name,all}
     * @param param    :班级某个属性的具体值 当kind=all时，param为任意非null值
     * @desciption:
     * @return: List<Class>类型的结果
     * @time: 2020/9/24 14:14
     */
    @Override
    public void findClassByKind(HttpServletRequest request, HttpServletResponse response, String kind, String param) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        List<Class> result = null;
        if (kind.equals("class_id")) {
            result = new ArrayList<>();
            result.add(classDao.getById(param));
        } else if (kind.equals("class_name")){
            result = classDao.getByName(param);
        }else if(kind.equals("all")){
            result = classDao.findAll();
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }

    /**
     * @param request
     * @param response
     * @param class_id
     * @desciption:
     * @return: List<Student>
     * @time: 2020/9/24 16:32
     */
    @Override
    public void getStudentsById(HttpServletRequest request, HttpServletResponse response, String class_id) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (class_id == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        List<Student> result = null;
        try{
            result = classDao.getStudentsById(class_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }

    /**
     * @param request
     * @param response
     * @param c        班级信息{class_id,class_name,t_id}
     * @desciption: 更新班级信息
     * @return:
     * @time: 2020/9/24 16:39
     */
    @Override
    public void updateClass(HttpServletRequest request, HttpServletResponse response, Class c) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (c == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            classDao.update(c);
            printWriter.println("更新班级信息成功！");
            System.out.println("更新班级"+c.toString()+"信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("更新班级信息失败！");
            System.out.println("更新班级"+c.toString()+"信息失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param c        班级信息{class_id,class_name,t_id}
     * @desciption: 删除班级
     * @return:
     * @time: 2020/9/24 16:39
     */
    @Override
    public void deleteClass(HttpServletRequest request, HttpServletResponse response, Class c) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (c == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            classDao.delete(c);
            printWriter.println("删除班级成功！");
            System.out.println("删除班级" + c.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("删除班级失败！");
            System.out.println("删除班级" + c.toString() + "失败！");
        }
    }


}
