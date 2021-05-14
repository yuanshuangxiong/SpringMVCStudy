<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/23
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iframe测试体验</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <script>
        function go() {
            //所有的值变量，提前获取
            var url=document.getElementById("url").value;
            document.getElementById("iframe").src=url;
        }

    </script>
</head>
<body>
<div>
    <p>
        请输入地址：
    </p>
    <p><input type="text" id="url">
        <input type="submit" value="提交" onclick="go()">
    </p>
</div>
<div>
    <iframe id="iframe" style="width:100%;height:500px"></iframe>
</div>

</body>
</html>
