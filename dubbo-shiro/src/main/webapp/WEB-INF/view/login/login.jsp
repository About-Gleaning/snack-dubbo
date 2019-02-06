<%--
  Created by IntelliJ IDEA.
  User: liurui
  Date: 2018/11/10
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/login/checkAccount" />
        用户名：<input type="text" name="account" />
        密码：<input type="password" name="password" />
        <input type="submit" value="登陆" />
    </form>

</body>
<script>
    $(function(){
        alert("a");
    });
</script>
</html>
