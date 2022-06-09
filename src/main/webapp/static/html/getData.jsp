<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2022/5/19
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询信息</title>
    <!--bootstrap4 dependence-->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="../js/jquery3.6.js"></script>
    <style>
        .jumbotron h1 a {
            text-decoration: none;
            color: black;
        }

        .jumbotron p a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<!--  调用ajax函数-->
<div class="jumbotron text-center" style="margin-bottom: 0">
    <h1><a class="nav-link" href="${pageContext.request.contextPath}/people/goMain">疫情人员管理系统</a></h1>
    <p>疫情终会过去，静候春暖花开。</p>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">导航</a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#collapsibleNavbar"
    >
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goMain">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goPeopleView">用户管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/static/html/collectInformation.jsp">收集信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#"
                ><strong>查询信息</strong></a
                >
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/">退出</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container" style="margin-top: 30px">
    <h1>
        查询信息<span class="badge bg-primary">管理员<small>FIND</small></span>
    </h1>
    <label for="tableName">表名：</label>
    <input type="text" class="form-control" id="tableName" name="tableName" placeholder="清输入你要查找的表名">
    <button class="btn btn-primary mb-3 mt-3" title="生成表格" onclick="newTable()">生成表格</button>
    <table class="table table-striped table-hover " id="myTable">
        <thead></thead>
        <tbody></tbody>
    </table>
</div>
<div class="jumbotron text-center" style="margin-bottom: 0">
    <p>
        Copyright © 2022
        <a href="https://github.com/Huang2001/PeopleManagement"
        >疫情人员管理系统</a
        >
    </p>
</div>
<script>
    // TODO: 根据表名生成对应数据表格
    function newTable() {
        // 获得表格名字
        var tableName = document.getElementById("tableName").value;
        var tableData = {title: tableName};
        var info = document.getElementById("newInfo");
        $("#newInfo").show();
        console.log(tableData)
        $.ajax({
            url: "/PeopleManagement/items/descItems",    //请求的url地址
            type: "POST",
            dataType: "json",   //返回格式为json
            async: true,//请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                "title": tableName
            },    //参数值
            success: function (data) {
                console.log(data);
                var keys = Object.keys(data.data[0])
                console.log(keys)
                // 每次生成前都需要清空表格
                $("#myTable>thead").empty();
                $("#myTable>tbody").empty();
                // TODO: 生成表格头
                $("#myTable>thead").append("<tr>")
                for (let i = 0; i < keys.length; i++) {
                    $("#myTable>thead").append("<th>" + keys[i] + "</th>")
                }
                $("#myTable>thead").append("</tr>")
                for (let i = 0; i < data.data.length; i++) {
                    var values = Object.values(data.data[i]);
                    console.log(values);
                    $("#myTable>tbody").append("<tr>")
                    for (let j = 0; j < values.length; j++) {
                        $("#myTable>tbody").append(
                            "<td>" + values[j] + "</td>"
                        )
                    }
                    $("#myTable>tbody").append("</tr>")
                }
            },
            error: function () {
                //请求出错处理
                alert("没有这个" + tableName + "表格");
            }
        });
    }

</script>
</body>

</html>
