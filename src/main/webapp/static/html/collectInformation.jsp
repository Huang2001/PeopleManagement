<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 2022/5/19
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>管理员__收集信息</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link
            rel="stylesheet"
            href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link
            rel="stylesheet"
            href="https://at.alicdn.com/t/font_3345561_xcn6ls2tm7.css?spm=a313x.7781069.1998910419.88&file=font_3345561_xcn6ls2tm7.css"
    />
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
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goMain?usern">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goPeopleView">用户管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#"
                ><strong>收集信息</strong></a
                >
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/static/html/getData.jsp">查询信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 30px">
    <h1>
        信息收集<span class="badge bg-primary">管理员<small>ADD</small></span>
    </h1>
    <form class="form-inline" action="">
        <label for="tableName" class="mb-2 mr-sm-2">表名：</label>
        <input
                type="text"
                class="form-control mb-2 mr-sm-2"
                id="tableName"
                name="tableName"
        />
        <label for="projectName" class="mb-2 ml-2 mr-sm-2">收集项目名称:</label>
        <input
                type="text"
                class="form-control mb-2 mr-sm-2"
                id="projectName"
                name="projectName"
        />
        <label for="select" class="mb-2 mr-sm-2">选择类型：</label>
        <select class="form-control mb-2" id="select">
            <option value="text">文本</option>
            <option value="image">图片</option>
        </select>
        <button
                type="button"
                class="btn btn-primary mr-2 mb-2 ml-2"
                onclick="addRow()"
        >
            添加
        </button>
        <input type="reset" value="重置" class="btn btn-warning mb-2"/>
        <table class="table table-hover" id="myTable">
            <thead>
            <tr id="tableHead">
                <th>信息名称</th>
                <th>信息类型</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tableBody"></tbody>
        </table>
        <button type="submit" class="btn btn-primary" style="margin: auto" onclick="ajax_test()">提交</button>
    </form>
</div>
<div class="jumbotron text-center" style="margin-bottom: 0">
    <p>
        Copyright © 2022
        <a href="https://github.com/Huang2001/PeopleManagement"
        >疫情人员管理系统</a
        >
    </p>
</div>
</body>
<script>
    function ajax_test() {
        // // 获得表名(数据库添加的表名)
        var titleName = document.getElementById("tableName").value;
        // 获取表格
        var myTable = document.getElementById("myTable");
        var rows = myTable.rows;
        for (var i = 1; i < rows.length; i++) {
            var cells = rows[i].cells;
            var testData = {"title": titleName};
            testData[cells[0].innerHTML] = cells[1].innerHTML;
            $.ajax({
                url: "/PeopleManagement/items/addItem",    //请求的url地址
                type: "POST",
                contentType: "application/json",
                dataType: "json",   //返回格式为json
                async: true,//请求是否异步，默认为异步，这也是ajax重要特性
                data: JSON.stringify(testData),
                success: function (data) {
                    if (data.code == 200) {
                        alert("yes！");
                    } else {
                        alert(data.message);
                    }
                },
                error: function () {
                    //请求出错处理
                    alert("请求出错！");
                }
            });
        }
    }

    function addRow() {
        var tbody = document.getElementById("tableBody");
        var row = document.createElement("tr"); // 创建行
        var selectValue = document.getElementById("select").value;
        var projectName = document.getElementById("projectName").value;
        var nameCell = document.createElement("td"); // 创建列
        var typeCell = document.createElement("td"); // 创建列
        var delCell = document.createElement("td"); // 创建列
        var delBtn = document.createElement("button");
        tbody.appendChild(row);
        row.appendChild(nameCell);
        row.appendChild(typeCell);
        row.appendChild(delCell);
        delBtn.setAttribute("type", "button");
        delBtn.setAttribute("class", "btn btn-danger");
        delBtn.setAttribute("href", "#");
        delBtn.innerText = "删除";
        delBtn.onclick = function () {
            if (confirm("确定删除这一行吗?")) {
                $(this).parent().parent().remove();
            }
        };
        delCell.appendChild(delBtn);
        nameCell.innerHTML = projectName;
        typeCell.innerHTML = selectValue;
    }

    function deleteRow() {
        if (confirm("你确定要删除这行吗?")) {
            console.log(this);
            // this.parent.parent.parent.removeChild(this.parent.parent);
            console.log("删除成功!!!");
        }
    }
</script>
</html>
