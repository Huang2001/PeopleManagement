<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goMain">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="${pageContext.request.contextPath}/people/goPeopleView"
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
                <a class="nav-link" href="${pageContext.request.contextPath}/Login/goLogin">退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 30px">
    <h1>用户管理 <span class="badge bg-primary">Modify</span></h1>
    <hr />
    <form action="${pageContext.request.contextPath}/people/updatePeople" method="post">
        <input type="hidden" name="id" value="${people.id}">
        <div class="form-group">
            <label for="userCode">用户账号:</label>
            <input type="text" class="form-control" id="userCode" name="userCode" value="${people.userCode}" />
        </div>
        <div class="form-group">
            <label for="userPassword">用户密码:</label>
            <input type="text" class="form-control" name="userPassword" id="userPassword" value="${people.userPassword}" />
        </div>
        <div class="form-group">
            <label for="username">用户姓名:</label>
            <input type="text" class="form-control" name="username" id="username" value="${people.username}" />
        </div>
        <div class="form-group">
            性别:
            <select name="gender" class="form-select" id="gender">
                <c:choose>
                    <c:when test="${people.gender == '男' }">
                        <option value="男" selected="selected">男</option>
                        <option value="女">女</option>
                    </c:when>
                    <c:otherwise>
                        <option value="男">男</option>
                        <option value="女" selected="selected">女</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age" name="age" value="${people.age}" />
        </div>
        <div class="form-group">
            <label for="address">地址:</label>
            <input type="text" class="form-control" id="address" name="address" value="${people.address}"/>
        </div>
        <div class="form-group">
            <label for="phoneNumber">电话号码</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${people.phoneNumber}"/>
        </div>
        <div class="form-group">
            <label for="roleName">角色名称</label>
            <input type="text" class="form-control" id="roleName" name="roleName" value="${people.roleName}" />
        </div>
        <div class="form-group">
            <label for="applicationTime">申请时间</label>
            <input type="text" class="form-control" id="applicationTime" name="applicationTime" value="<fmt:formatDate value="${people.applicationTime}" pattern="yyyy-MM-dd"/>"/>
        </div>
        状态:
        <c:choose>
            <c:when test="${people.state == '健康' }">
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state1" name="state" value="健康" checked/>
                    <label class="form-check-label" for="state1">健康</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state2" name="state" value="阳性"/>
                    <label class="form-check-label" for="state2">阳性</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state3" name="state"  value="确诊" />
                    <label class="form-check-label">确诊</label>
                </div>
            </c:when>
            <c:when test="${people.state == '阳性' }">
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state4" name="state" value="健康"/>
                    <label class="form-check-label" for="state1">健康</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state5" name="state" value="阳性" checked/>
                    <label class="form-check-label" for="state2">阳性</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state6" name="state"  value="确诊" />
                    <label class="form-check-label">确诊</label>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state7" name="state" value="健康"/>
                    <label class="form-check-label" for="state1">健康</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state8" name="state" value="阳性"/>
                    <label class="form-check-label" for="state2">阳性</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="state9" name="state"  value="确诊" checked />
                    <label class="form-check-label">确诊</label>
                </div>
            </c:otherwise>
        </c:choose>
        <input type="submit" class="btn btn-success mb-2" />
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
<script>

</script>
</body>
</html>
