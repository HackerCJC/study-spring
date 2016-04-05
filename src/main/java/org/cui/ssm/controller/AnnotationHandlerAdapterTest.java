package org.cui.ssm.controller;

import org.cui.ssm.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/4.
 * 类上加requestmapping：窄化请求映射 ,过此方法对url进行分类管理。
 */
@Controller
@RequestMapping("item")
public class AnnotationHandlerAdapterTest {

    /**
     * RequestMapping是一个数组 可以将多个url映射到同一个方法
     * method = RequestMethod.POST ：限定请求方式 限定为post get就不好使
     *
     * @return
     */
//    @RequestMapping("/queryItem.do")
    @RequestMapping(value = {"query1.do", "query2.do"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView queryItem() {
        // 商品列表
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");
        itemsList.add(items_1);
        itemsList.add(items_2);
        // 创建modelAndView准备填充数据、设置视图
        ModelAndView modelAndView = new ModelAndView();        // 填充数据
        modelAndView.addObject("itemsList", itemsList);
        // 视图
        modelAndView.setViewName("order/itemsList");
        return modelAndView;
    }


    /**
     * controller 方法返回值：void
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"query3.do", "query4.do"}, method = {RequestMethod.POST, RequestMethod.GET})
    public void queryItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 商品列表
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");
        itemsList.add(items_1);
        itemsList.add(items_2);
        // 可以不使用 modelAndView 返回结果
//        ModelAndView modelAndView = new ModelAndView();        // 填充数据
//        modelAndView.addObject("itemsList", itemsList);
        // 视图
//        modelAndView.setViewName("order/itemsList");
        // 转发 由request发出
//        request.setAttribute("itemsList", itemsList);
//        request.getRequestDispatcher("/WEB-INF/jsp/order/itemsList.jsp").forward(request, response);
        // 重定向 由 response 发出
//        response.sendRedirect("");

        // 还可以返回json字符串
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json串");
    }


    /**
     * controller 方法返回值：String
     *
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"query5.do", "query6.do"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryItem(Model model) throws ServletException, IOException {
        // 商品列表
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");
        itemsList.add(items_1);
        itemsList.add(items_2);
        // 可以不使用 modelAndView 返回结果
//        ModelAndView modelAndView = new ModelAndView();        // 填充数据
//        modelAndView.addObject("itemsList", itemsList);
        // 视图
//        modelAndView.setViewName("order/itemsList");
        // 转发 由request发出
//        request.setAttribute("itemsList", itemsList);
//        request.getRequestDispatcher("/WEB-INF/jsp/order/itemsList.jsp").forward(request, response);
        // 重定向 由 response 发出
//        response.sendRedirect("");

        // 还可以返回json字符串
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write("json串");
        model.addAttribute("itemsList", itemsList);
        // 返回逻辑视图名
        return "order/itemsList";
    }


    /**
     * 重定向/转发演示
     * 相当于“response.sendRedirect()
     *
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"query7.do", "query6.do"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String queryItem2(Model model) throws ServletException, IOException {
        // 重定向  相当于“response.sendRedirect()
        return "redirect:query3.do";
        // 转发 相当于 request.getRequestDispatcher().forward(request,response)
//        return "forware:query3.do";
    }
}
