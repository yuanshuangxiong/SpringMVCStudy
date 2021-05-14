<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/23
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script
              src="https://code.jquery.com/jquery-3.6.0.js"
              integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
              crossorigin="anonymous">

      </script>
    <script>
      function a(){
          $.post({
             url:"${pageContext.request.contextPath}/a1",
             data:{"name":$("#username").val()},
             success:function (data){
                alert(data);
             }
           })
      }

    </script>

  </head>
  <body>

      用户名：<input id="username" type="text" onblur="a()">










  </body>
</html>
