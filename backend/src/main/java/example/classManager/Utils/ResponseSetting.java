package example.classManager.Utils;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 2020/9/24
 */
public class ResponseSetting {
    public static HttpServletResponse responseSetJson(HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("application/json;charset=utf-8");
        return httpServletResponse;
    }
    public static HttpServletResponse responseSetHtml(HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("text/html;charset=utf-8");
        return httpServletResponse;
    }
    public static PrintWriter getPrinterWriter(HttpServletResponse httpServletResponse) throws IOException {
        return new PrintWriter((httpServletResponse.getWriter()));
    }
    public static String sendStatus(int STATUS_CODE){
        return null;
    }
    public static void PrintJsonObject(PrintWriter printWriter,Object object){
        JSONArray jsonArray = JSONArray.fromObject(object);
        System.out.println(jsonArray.toString());
        printWriter.println(jsonArray);
    }
}
