<%--
  Created by IntelliJ IDEA.
  User: 10851
  Date: 2019/6/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
           <%-- <a href="param/testParam?username=hehe&password=hehe">请求参数绑定</a>--%>

    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>

        用户姓名：<input type="text" name="list[0].name" /><br/>
        用户年龄：<input type="text" name="list[0].age" /><br/>
 
        用户姓名：<input type="text" name="map['one'].name" /><br/>
        用户年龄：<input type="text" name="map['one'].age" /><br/>
        <input type="submit" value="提交" /><br/>
    </form>
</body>
</html>
