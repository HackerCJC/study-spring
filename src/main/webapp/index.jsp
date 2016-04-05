<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/3
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%--JSP默认不支持EL表达式，配置以下内容即可--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="application/javascript">

        //请求json响应json
        function request_json() {
//            alert("hello request_json")
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath }/json.do",
                contentType: "application/json;charset=utf-8",
                data: '{"name":"测试商品","price":99.9}',
                success: function (data) {
//                    alert(data);
                    console.info(data)
                }
            });
        }
    </script>
</head>
<body>


项目首页
<input type="button" onclick="request_json()" value="发送jso格式数据请求">
</body>
</html>