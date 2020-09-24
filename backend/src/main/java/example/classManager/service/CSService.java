package example.classManager.service;

import example.classManager.entity.CS;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 2020/9/24
 */
public interface CSService {


    /**
    * @desciption: 增加学生选课
     * @param cs CS{s_id,c_id}
    * @return: 字符串类型的成功与否信息
    * @time: 2020/9/24 17:09
    */
    public void add(HttpServletRequest request, HttpServletResponse response, CS cs) throws IOException;


    /**
     * @desciption: 删除学生选课
     * @param cs CS{s_id,c_id}
     * @return: 字符串类型的成功与否信息
    * @time: 2020/9/24 17:09
    */
    public void delete(HttpServletRequest request, HttpServletResponse response,CS cs) throws IOException;


    /**
    * @desciption:
     * @param kind:指通过CS的某个属性来搜索满足条件的学生列表，kind的可选域为:{s_id,course_id}
     * @param param:CS某个属性的具体值
    * @return:  List<CS>
    * @time: 2020/9/24 19:48
    */
    public void findCssByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param")String param) throws IOException;

}
