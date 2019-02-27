<%--
  Created by IntelliJ IDEA.
  User: frankstar
  Date: 2019/2/25
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Map" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>

    <h2>商品列表</h2>
    <a href="<c:url value="/shop?action=viewCart" />">购物车</a><br/><br/>
    <%
        @SuppressWarnings("unchecked")
        String products = request.getParameter("product");
        Map<Integer, String> product = (Map<Integer, String>) JSONObject.parseObject(products);
        for (int id : product.keySet()) {
        	%><a href="<c:url value="/shop">
        	<c:param name="action" value="addCart"/>
            <c:param name="productId" value="<%= Integer.toString(id)%>"/>
        </c:url> "><%=product.get(id)%></a><br/><%
        }
    %>
</body>
</html>
