package example.classManager.service.serviceImp;

import example.classManager.Utils.ResponseSetting;
import example.classManager.dao.CSDao;
import example.classManager.entity.CS;
import example.classManager.service.CSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created on 2020/9/24
 */
@Service
public class CSServiceImp implements CSService {
    @Autowired
    CSDao csDao;

    /**
     * @param request
     * @param response
     * @param cs       CS{s_id,c_id}
     * @desciption: 增加学生选课
     * @return: 字符串类型的成功与否信息
     * @time: 2020/9/24 17:09
     */
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response, CS cs) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (cs == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            csDao.add(cs);
            printWriter.println("添加选课成功！");
            System.out.println("添加选课" + cs.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("添加选课失败！");
            System.out.println("添加选课" + cs.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param cs       CS{s_id,c_id}
     * @desciption: 删除学生选课
     * @return: 字符串类型的成功与否信息
     * @time: 2020/9/24 17:09
     */
    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response, CS cs) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        if (cs == null) {
            printWriter.println("接受参数失败！");
            return;
        }
        try {
            csDao.delete(cs);
            printWriter.println("删除选课成功！");
            System.out.println("删除选课" + cs.toString() + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("删除选课失败！");
            System.out.println("删除选课" + cs.toString() + "失败！");
        }
    }

    /**
     * @param request
     * @param response
     * @param kind     :指通过CS的某个属性来搜索满足条件的学生列表，kind的可选域为:{s_id,course_id}
     * @param param    :CS某个属性的具体值
     * @desciption:
     * @return: List<CS>
     * @time: 2020/9/24 19:48
     */
    @Override
    public void findCssByKind(HttpServletRequest request, HttpServletResponse response, String kind, String param) throws IOException {
        response = ResponseSetting.responseSetJson(response);
        PrintWriter printWriter = ResponseSetting.getPrinterWriter(response);
        List<CS> result = null;
        if (kind.equals("s_id")) {
            result=csDao.getByStudentId(param);
        } else if (kind.equals("course_id")){
            result = csDao.findCSById(param);
        }
        ResponseSetting.PrintJsonObject(printWriter,result);
    }


}
