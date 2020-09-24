package example.classManager.controller;

import example.classManager.entity.Class;
import example.classManager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/23
 */
@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @PostMapping("/addClass")
    /**
     * @param c : class{class_id,class_name,t_id}
     * @desciption: 添加班级，返回添加成功或失败的信息
     * @return: 字符串形式的信息
     */
    public void addClass(HttpServletRequest request, HttpServletResponse httpServletResponse, Class c) throws IOException {
        classService.addClass(request,httpServletResponse,c);
    }

    @PostMapping("/findClassByKind")
    /**
     * @param kind:指通过学生的某个属性来搜索满足条件的班级列表，kind的值域为:{class_id,class_name,all}
     * @param param:班级某个属性的具体值                                               当kind=all时，param为任意非null值
     * @desciption:
     * @return: List<Class>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findClassByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param") String param) throws IOException {
        classService.findClassByKind(request, response, kind, param);
    }

    @PostMapping("/findStudentByClassId")
    /**
     * @param class_id
     * @desciption:
     * @return: List<Student>
     * @time: 2020/9/24 16:32
     */
    public void getStudentsById(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "class_id") String class_id) throws IOException {
        classService.getStudentsById(request,response,class_id);
    }

    @PostMapping("/updateClass")
    /**
     * @param c class{class_id,class_name,t_id}
     * @desciption: 更新班级信息
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void updateClass(HttpServletRequest request, HttpServletResponse response, Class c) throws IOException {
        classService.updateClass(request,response,c);
    }

    @PostMapping("/deleteClass")
    /**
     * @param c 班级信息{class_id,class_name,t_id}
     * @desciption: 删除班级
     * @return:
     * @time: 2020/9/24 16:39
     */
    public void deleteClass(HttpServletRequest request, HttpServletResponse response, Class c) throws IOException {
        classService.deleteClass(request,response,c);
    }

}
