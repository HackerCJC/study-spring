package org.cui.ssm.controller;

import org.cui.ssm.pojo.Items;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/4.
 * http请求处理器适配器
 */
public class HttpRequestHandlerAdapterTest implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 商品列表
        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone5  苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);
        // 填充数据
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("/WEB-INF/jsp/order/itemsList.jsp").forward(request, response);
    }
}
