package example.classManager.controller;

import example.classManager.entity.CS;
import example.classManager.service.CSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/9/24
 */
@CrossOrigin
@Controller
public class CSController {
    @Autowired
    CSService csService;

    @PostMapping("/addCs")
    /**
     * @param cs CS{s_id,c_id}
     * @desciption: 增加学生选课
     * @return: 字符串类型的成功与否信息
     * @time: 2020/9/24 17:09
     */
    public void add(HttpServletRequest request, HttpServletResponse response, CS cs) throws IOException {
        csService.add(request, response, cs);
    }

    @PostMapping("/deleteCs")
    /**
     * @param cs CS{s_id,c_id}
     * @desciption: 删除学生选课
     * @return: 字符串类型的成功与否信息
     * @time: 2020/9/24 17:09
     */
    public void delete(HttpServletRequest request, HttpServletResponse response, CS cs) throws IOException {
        csService.delete(request,response,cs);
    }

    @PostMapping("/findCsByKind")
    /**
     * @param kind:指通过CS的某个属性来搜索满足条件的CS列表，kind的可选域为:{s_id,course_id}
     * @param param:CS某个属性的具体值
     * @desciption:
     * @return: List<CS>
     * @time: 2020/9/24 19:48
     */
    public void findCssByKind(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "kind") String kind, @RequestParam(name = "param",required = false) String param) throws IOException {
        csService.findCssByKind(request,response,kind,param);
    }

}
