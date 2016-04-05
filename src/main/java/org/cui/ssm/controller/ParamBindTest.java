package org.cui.ssm.controller;

import org.cui.ssm.pojo.Items;
import org.cui.ssm.pojo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 参数绑定
 * 处理器在执行Handler之前需要把 请求的key/value 数据绑定到Hadler形参上
 * 处理器方法上添加如下类型的形参适配器会识别并赋值:
 * HttpServletRequest:通过request对象获取请求信息
 * HttpServletResponse: 通过response对象处理响应信息
 * HttpSession ： 通过session对象获取session域中存放的数据
 * Model/ModelMap :ModelMap是Model的一个接口实现 ，通过Model或者ModelMap向页面传递数据
 * /调用service查询商品信息
 * Items item = itemService.findItemById(id);
 * model.addAttribute("item", item);
 * 页面通过${item.XXXX}获取item对象的属性值。
 * 使用Model和ModelMap的效果一样，如果直接使用Model，springmvc会实例化ModelMap。
 * Created by Administrator on 2016/4/4.
 */
@Controller
@RequestMapping("/paramBind")
public class ParamBindTest {
    /**
     * 简单类型
     * 当请求参数的名称与处理器形参名称一致时会将请求参数与形参绑定
     *
     * @param name
     * @param age
     * @param score
     */
    @RequestMapping(value = {"basicType.do"})
    public void basicType(HttpServletResponse response, String name, Integer age, Double score) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("name=" + name + "\t" + "age=" + age + "\t" + "score=" + score);
    }


    /**
     * RequestParam:
     * 使用@RequestParam常用于处理简单类型的绑定。
     */
    @RequestMapping(value = {"requestParam.do"})
    public void requestParam(HttpServletResponse response, @RequestParam(value = "item_id", required = true, defaultValue = "123456") Integer id) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("id=" + id);
    }

    /**
     * 简单pojo:
     * 如果传入的参数名和pojo的属性名一致，则将参数值设置在pojo对象中
     */
    @RequestMapping(value = {"pojo.do"})
    public void requestParamPojo(HttpServletResponse response, Items items) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("item.di=" + items.getId());
        response.getWriter().write("item=" + items);
    }

    /**
     * 包装pojo:
     * 如果传入的参数名和pojo的属性名一致，则将参数值设置在pojo对象中
     */
    @RequestMapping(value = {"pojo2.do"})
    public void requestParamPojo_baozhuang(HttpServletResponse response, QueryVo vo) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("vo.Items=" + vo.getItems());
    }


    /**
     * 自定义参数类型绑定：
     * 例子：日期类型转换
     * 请求参数item.name=  item.id=
     */
    @RequestMapping(value = {"convertor.do"})
    public void requestParamCustomer(HttpServletResponse response, QueryVo vo) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("vo.Items=" + vo.getItems());
    }

    /**
     * 字符串数组
     * 请求参数idss=1,2,3,4
     */
    @RequestMapping(value = {"arr.do"})
    public void requestParamCustomer(HttpServletResponse response, @RequestParam(value = "idss") String[] ids) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("ids.len: " + ids.length);
        for (String id : ids) {
            response.getWriter().write("id=" + id);
        }
    }


    /**
     * List
     * List中存放对象，并将定义的List放在包装类中，action使用包装对象接收。
     * 请求URL:http://localhost:8080/paramBind/list.do?itemList[0].name=leo
     * 返回：vo.itermList: [Items{id=null, name='leo', price=null, pic='null', createtime=null, detail='null'}]
     * Handler形参：QueryVo
     */
    @RequestMapping(value = {"list.do"})
    public void requestParamList(HttpServletResponse response, QueryVo vo) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("vo.itermList: " + vo.getItemList());
    }

    /**
     * Map
     * 在包装类中定义Map对象，并添加get/set方法，action使用包装对象接收。
     * 包装类中定义Map对象如下：
     * 请求url：http://localhost:8080/paramBind/map.do?itemInfo[name]=zhangsan
     * response响应： vo.itemInfo: {name=zhangsan}
     */
    @RequestMapping(value = {"map.do"})
    public void requestParamMap(HttpServletResponse response, QueryVo vo) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("vo.itemInfo: " + vo.getItemInfo());

    }


    /**
     * 请求参数验证：
     */
    @RequestMapping(value = {"validate.do"})
    public void requestParamValidate(HttpServletResponse response, Items items) throws IOException {
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/application/x-www-form-urlencoded;charset=utf-8");
        response.setContentType("charset=utf-8");
        response.getWriter().write("items: " +items );

    }
}
