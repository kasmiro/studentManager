package example.classManager.service;

import example.classManager.entity.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/24
 */
public interface TeacherService {


    /**
    * @desciption:
     * @param teacher 通过json的方式提交Teacher实体类{t_id,t_name}
    * @return:
    * @time: 2020/9/24 15:09
    */
    public void addTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException;


    /**
     * @desciption:
     * @param kind:指通过老师的某个属性来搜索满足条件的老师，kind的值域为:{t_id,all}
     * @param param:老师某个属性的具体值，当kind=all的时候，param可以为任意值
     * @return: List<Teacher>类型的结果
     * @time: 2020/9/24 14:14
     */
    public void findTeachersByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param") String param) throws IOException;


    /**
    * @desciption: 通过老师的id来找老师管理的班级
     * @param t_id
    * @return: Json格式的Class
    * @time: 2020/9/24 15:18
    */
    public void getClassById(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "t_id") String t_id) throws IOException;



    /**
    * @desciption: 通过老师的id来获取老师教的课程
     * @param t_id
    * @return: Json格式的List<Course>
    * @time: 2020/9/24 15:20
    */
    public void getCoursesById(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "t_id") String t_id) throws IOException;


    /**
     * @desciption: 更新教师信息
     * @param teacher   以json的格式提交教师信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void updateTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException;


    /**
     * @desciption: 删除教师
     * @param teacher 以json的格式提交教师信息
     * @return: 返回成功与否的结果
     * @time: 2020/9/24 14:47
     */
    public void deleteTeacher(HttpServletRequest request, HttpServletResponse httpServletResponse, Teacher teacher) throws IOException;
}
