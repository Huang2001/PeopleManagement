<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>用户管理</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            rel="stylesheet"
            href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <link
            href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            width: 200px;
            /* background: #aaa; */
        }
        .fakeimg img {
            border-radius: 50%;
            height: 200px;
            width: 200px;
        }
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
    <h1><a href="index.html">疫情人员管理系统</a></h1>
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
                <a class="nav-link" href="../index.jsp">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="#"
                ><strong>用户管理</strong></a
                >
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">角色管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">部门管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 30px">
    <h1>用户管理 <span class="badge bg-primary">Add</span></h1>
    <hr />
    <form action="${pageContext.request.contextPath}/people/addPeople">
        <div class="form-group">
            <label for="userCode">用户账号:</label>
            <div class="info text-center" style="color: red ;font-size: 15px">${msg}</div>
            <input type="text" class="form-control" id="userCode" name="userCode"/>
        </div>
        <div class="form-group">
            <label for="userPassword">用户密码:</label>
            <input type="text" class="form-control" id="userPassword" name="userPassword" />
        </div>
        <div class="form-group">
            <label for="username">用户姓名:</label>
            <input type="text" class="form-control" id="username" name="username"/>
        </div>
        <div class="form-group">
            性别:
            <select name="gender" class="form-select">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age" name="age"/>
        </div>
        <div class="form-group">
            <label for="address">地址:</label>
            <input type="text" class="form-control" id="address" name="address" />
        </div>
        <div class="form-group">
            <label for="phoneNumber">电话号码</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" />
        </div>
        <div class="form-group">
            <label for="roleName">角色名称</label>
            <input type="text" class="form-control" id="roleName" name="roleName"/>
        </div>
        <div class="form-group">
            <label for="applicationTime">申请时间</label>
            <input type="date" class="form-control" id="applicationTime" name="applicationTime" />
        </div>
        状态:
        <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="state" value="健康" checked/>
            <label class="form-check-label" for="radio1">健康</label>
        </div>
        <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="state" value="阳性"/>
            <label class="form-check-label" for="radio2">阳性</label>
        </div>
        <div class="form-check">
            <input type="radio" class="form-check-input" name="state" value="确诊" />
            <label class="form-check-label">确诊</label>
        </div>
        <input type="submit" class="btn btn-success mb-2" value="添加"/>
        <input type="reset" value="重置" class="btn btn-warning mb-2" />
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
</html>
