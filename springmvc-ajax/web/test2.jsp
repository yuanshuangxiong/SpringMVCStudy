<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/23
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous">

    </script>
    <script>
        $(function(){
            $("#btn").click(function(){
                $.post("${pageContext.request.contextPath}/a2",function(data){
                    var html="";
                    for(let i=0;i<data.length;i++){
                        html+="<tr>"+
                                "<td>"+data[i].id+"</td>"+
                                "<td>"+data[i].name+"</td>"+
                                "<td>"+data[i].sex+"</td>"+
                            "</tr>";
                    }
                    $("#content").html(html);
                });
            });
        });

    </script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
    </tr>
    <tbody id="content">

    </tbody>
</table>

</body>
</html>
