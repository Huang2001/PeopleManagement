<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>主页</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link
            rel="stylesheet"
            href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                <strong>
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/people/goMain?usern">首页</a>
                </strong>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/people/goPeopleView">用户管理</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/static/html/collectInformation.jsp">收集信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/static/html/getData.jsp">查询信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Login/goLogin">退出</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-sm-4">
            <h2>欢迎 <small>${people.username}</small></h2>
            <!-- <h5>疫情人员管理系统</h5> -->
            <div class="fakeimg">
                <img
                        src="https://img.51miz.com/preview/element/00/01/11/14/E-1111405-7071F8EA.jpg"
                        alt="无法显示"
                />
            </div>
            <p>来自${people.address}的小可爱一枚</p>
            <h3></h3>
            <p>当前健康状态</p>
            <!-- <ul class="nav nav-pills flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="#">健康</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">阳性</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">确诊</a>
              </li>
            </ul> -->
            <div class="radio">
                <label><input type="radio" name="optradio" checked/> 健康</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="optradio"/> 阳性</label>
            </div>
            <div class="radio disabled">
                <label><input type="radio" name="optradio"/> 确诊</label>
            </div>
            <hr class="d-sm-none"/>
        </div>
        <div class="col-sm-8">
            <h2>疫情人员管理系统</h2>
            <p>
                一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适自己的。于是利用空闲休息时间开始自己写一套后台系统。如此有了疫情人员管理系统。，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。
            </p>
            <br/>
            <h2>更新日志</h2>
            <ul>
                <li>1.添加用户管理</li>
                <li>2.添加角色管理</li>
                <li>3.添加部门管理</li>
            </ul>
        </div>
    </div>
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
