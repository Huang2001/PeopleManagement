<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>极客开发者-用户中心|注册</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/public.css2">
</head>
<body>
<div id="bg"></div>
<div class="show">
    <h3 class="title">登录中心</h3>
    <div class="login-panel">
        <h4 class="form-title">登录&nbsp;账号</h4>
        <hr class="top-line">
        <form action="${pageContext.request.contextPath}/Login/login.do" method="post" onsubmit="return check();" name="myfom">
            <div class="form-group">
                <div class="info text-center" style="color: red ;font-size: 15px">${msg}</div>
                <label for="userCode">用户名</label>
                <input type="text" class="form-control" id="userCode" name="userCode">
                <span id="info" style="display: none;"></span>
            </div>
            <div class="form-group">
                <label for="userPassword">密码</label>
                <input type="password" class="form-control" id="userPassword" name="userPassword">
                <span id="info2" style="display: none;">1</span>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info" id="submit">登录</button>
            </div>
            <div class="order">
                <span class="line"></span>
                <span class="txt">第三方账号登录</span>
                <span class="line"></span>
            </div>
            <div class="row">
                <button class="col-md-5 col-sm-5 col-xs-5 btn-login left">QQ</button>
                <span class="col-md-2 col-sm-2 col-xs-2"></span>
                <button class="col-md-5 col-sm-5 col-xs-5 btn-login right">微信</button>
            </div>
        </form>
    </div>

    <div class="switch row">
        <a href="${pageContext.request.contextPath}/Login/goRegister"><button class="switch-action"style="color: red">&lt;&nbsp;还没有账号？<span style="color: red">立即注册</span></button></a>
    </div>

    <div class="bottom-info">
        <span style="color: red">技术支持：</span><a href="https://jkdev.cn" style="color: red">开发者中心</a>&nbsp;•&nbsp;<a href="https://jkdev.cn/about.php" style="color: red">关于我们</a>
    </div>
</div>
<script >
    function check(){
        var userCode,info,password,info2;
        userCode=myfom.userCode.value;
        info=document.getElementById('info');
        password=myfom.userPassword.value;
        info2=document.getElementById('info2');
        if (userCode.length==0 || userCode==null) {
            info.innerHTML='用户名不能为空';
            info.style.color='#f00';
            info.style.display='inline';
            info.style.fontSize='5px';
            return false;
        }
        if (password.length==0 || password==null) {
            info2.innerHTML='密码不能为空';
            info2.style.color='#f00';
            info2.style.display='inline';
            info2.style.fontSize='5px';
            return false;
        }
    }
</script>
</body>
</html>