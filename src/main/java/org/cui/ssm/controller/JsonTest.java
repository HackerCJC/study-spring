package org.cui.ssm.controller;

import org.cui.ssm.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/4/4.
 * RequestBody ： sprinvmvc通过httpmessageConverter 将请求参数数据转换成json
 * ResponseBody ： springmvc 通过httpmessageConverter 将 handler返回值对象转换为json数据
 */
@Controller
public class JsonTest {

    /**
     * 发送json 响应json
     *
     * @param response
     * @param items
     * @return
     */
    @RequestMapping("/json.do")
    public
    @ResponseBody
    Items jsonTest(HttpServletResponse response, @RequestBody Items items) {
        System.out.println("RequestBody转换后：" + items);
        return items;
    }


    /**
     * 发送key/value 响应json
     *
     * @param response
     * @param items
     * @return
     */
    @RequestMapping("/json2.do")
    public
    @ResponseBody
    Items jsonTest2(HttpServletResponse response, Items items) {
        System.out.println("request接受数据：" + items);
        return items;
    }
}
