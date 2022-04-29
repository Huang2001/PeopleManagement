<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link
            rel="stylesheet"
            href="https://at.alicdn.com/t/font_3345561_jds2xsq8wdd.css?spm=a313x.7781069.1998910419.116&file=font_3345561_jds2xsq8wdd.css"
    />
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
        table {
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }
        .container{
            margin-left: 10%;
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
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goMain?usern">首页</a>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/Login/goLogin">退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 30px">
    <div class="col-sm-12">
        <form class="form-inline" action="${pageContext.request.contextPath}/people/goPeopleView">
            <label for="userName" class="mb-2 mr-sm-2">用户姓名: </label>
            <input
                    type="text"
                    class="form-control mb-2 mr-sm-2"
                    id="userName"
                    placeholder="输入用户名"
                    name="username"
            />
            <label for="userAddress" class="mb-2 mr-sm-2">地址: </label>
            <input
                    type="text"
                    class="form-control mb-2 mr-sm-2"
                    id="userAddress"
                    placeholder="输入地址"
                    name="address"
            />
            身体状态:
            <select name="state" class="custom-select-sm ml-1 mr-1">
                <option value="" selected>所有</option>
                <option value="健康">健康</option>
                <option value="阳性">阳性</option>
                <option value="确诊">确诊</option>
            </select>
            性别:
            <select name="gender" class="custom-select-sm ml-1">
                <option  value="" selected>所有</option>
                <option value="男" name="gender">男</option>
                <option value="女" name="gender">女</option>
            </select>
            <button type="submit" class="btn btn-primary mb-2 mr-2 ml-2">
                <i class="iconfont icon-fangdajing"></i> 搜索
            </button>
            <button
                    type="button"
                    class="btn btn-warning mb-2"
                    onclick="clearContext()"
            >
                <i class="iconfont icon-shuaxin"></i>重置
            </button>
        </form>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/people/toAddPeople" class="btn btn-success"
        ><i class="iconfont icon-xinzeng"></i>新增</a
        >
    </div>
    <table class="table table-hover mt-2">
        <thead>
        <tr>
            <th>id</th>
            <th>账号</th>
            <th>密码</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>状态</th>
            <th class="text-center">地址</th>
            <th>电话号码</th>
            <th>角色名称</th>
            <th>申请时间</th>
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="people" items="${pageInfo.list}">
            <tr>
                <td>${people.id}</td>
                <td>${people.userCode}</td>
                <td>${people.userPassword}</td>
                <td>${people.username}</td>
                <td>${people.gender}</td>
                <td>${people.age}</td>
                <td>
                    <c:if test="${people.state=='确诊'}"><span style="color: red">确诊</span></c:if>
                    <c:if test="${people.state=='阳性'}"><span style="color: orange">阳性</span></c:if>
                    <c:if test="${people.state=='健康'}"><span style="color: green">健康</span></c:if>
                </td>
                <td>${people.address}</td>
                <td>${people.phoneNumber}</td>
                <td>${people.roleName}</td>
                <td><fmt:formatDate value="${people.applicationTime}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/people/goUpdate?id=${people.id}" class="btn btn-primary"
                    ><i class="iconfont icon-bianji"></i>编辑</a
                    >
                    <a href="${pageContext.request.contextPath}/people/deletePeople?id=${people.id}" class="btn btn-danger"
                    ><i class="iconfont icon-shanchu"></i>删除</a
                    >
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination float-right">
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/people/goPeopleView?page=1&username=${username}&address=${address}&gender=${gender}&state=${state}">首页</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/people/goPeopleView?page=${pageInfo.pageNum-1}&address=${address}&gender=${gender}&state=${state}">上一页</a></li>
        <li class="page-item"><a class="page-link disabled" href="#">${pageInfo.pageNum}/共${pageInfo.pages}页</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/people/goPeopleView?page=${pageInfo.pageNum+1}&address=${address}&gender=${gender}&state=${state}">下一页</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/people/goPeopleView?page=${pageInfo.pages}&username=${username}&address=${address}&gender=${gender}&state=${state}">尾页</a></li>
    </ul>
</div>

<div class="jumbotron text-center" style="margin-bottom: 0">
    <p>
        Copyright © 2022
        <a href="https://github.com/Huang2001/PeopleManagement">疫情人员管理系统</a>
    </p>
</div>
<script>
    var userName = document.getElementById("userName");
    var userAddress = document.getElementById("userAddress");
    function clearContext() {
        // alert("hello,world");
        // userName.innerTeHTMLxt = "hello,world";
        userName.value = "";
        userAddress.value = "";
    }
</script>
</body>
</html>
