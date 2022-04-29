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
    <h3 class="title">用户中心</h3>
    <div class="login-panel">
        <h4 class="form-title">注册账号</h4>
        <hr class="top-line">
        <form action="${pageContext.request.contextPath}/people/registerPeople" method="post" onsubmit="return check();" name="myfom">
            <div class="form-group">
                <label for="userCode">用户名</label>
                <div class="info text-center" style="color: red ;font-size: 15px">${msg}</div>
                <input type="text" class="form-control" id="userCode" name="userCode">
                <span id="info" style="display: none;"></span>
            </div>
            <div class="form-group">
                <label for="userPassword">密码</label>
                <input type="password" class="form-control" id="userPassword" name="userPassword">
                <span id="info2" style="display: none;"></span>
            </div>
            <div class="form-group">
                <label for="phoneNumber">手机号码</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                <span id="info3" style="display: none;"></span>
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
                <input type="radio" class="form-check-input" id="radio3" name="state" value="确诊" />
                <label class="form-check-label" for="radio3">确诊</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info" id="submit">注册</button>
            </div>
        </form>
    </div>

    <div class="switch row">
        <a href="${pageContext.request.contextPath}/Login/goLogin"><button class="switch-action" id="login" style="color: red">已经注册过账号？<span style="color: red"立即登录</span></button></a>
    </div>

    <div class="bottom-info">
        <span style="color: red"> Powered By：</span><a href="https://jkdev.cn" style="color: red"极客开发者</a>&nbsp;•&nbsp;<a href="https://jkdev.cn/about.php"style="color: red">关于我们</a>
    </div>
</div>

<script >
    function check(){
        var userCode,info,password,info2,phoneNumber,info3;
        userCode=myfom.userCode.value;
        info=document.getElementById('info');
        password=myfom.password.value;
        info2=document.getElementById('info2');
        phoneNumber=myfom.phoneNumber.value;
        info3=document.getElementById('info3');
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
        if (phoneNumber.length==0 || phoneNumber==null) {
            info3.innerHTML='手机号码不能为空';
            info3.style.color='#f00';
            info3.style.display='inline';
            info3.style.fontSize='5px';
            return false;
        }
    }
</script>

</body>
</html>