<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../dest/css/normalize.css" />
    <link rel="stylesheet" href="../dest/css/style.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style>
        .layui-form-item {
            margin-bottom: 0;
            clear: both;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <header class="header">
        <div class="full-center">
            <div style="width:400px;height:219px;">
                <div  style="height:100%;background:#fff;    box-shadow: 0px 0px 20px 0px #423e3e;">
                    <from class="layui-form layui-form-pane">
                        <div class="layui-form-item">
                            <div class="layui-input-inline" style="margin:10px 20px 0 20px">
                                <input type="text" name="username" lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-inline" style="margin:10px 20px 0 20px">
                                <input type="text" name="username" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item" >
                            <div class="layui-input-inline layui-input-block" style="margin:10px 20px 0 20px">
                                <input type="checkbox" name="like1[write]" lay-skin="primary" title="写作" checked="">
                                <a style="text-decoration: underline;color: lightseagreen;cursor: pointer;position: absolute;right: 5px;bottom: 0px;">忘记密码</a>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-inline" style="margin:10px 20px 0 20px">
                                <button class="layui-btn layui-btn-primary" style="width:190px">提交</button>
                            </div>
                        </div>
                    </from>
                </div>
            </div>
        </div>
        <!--
        <div class="arrow__btn">
            <a href="#main" class="btn">
                <img src="dest/img/download.svg" alt="" width="50" height="50">
            </a>
        </div>
        -->
    </header>
</div>
<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="../js/jquery-1.11.0.min.js"><\/script>')</script>
<script src="../dest/main.js"></script>
<script src="../dest/circleMagic.min.js"></script>
<script src="../layui/layui.all.js"></script>
<script>
    $('.header').circleMagic({
        elem: '.header',
        radius: 35,
        densety: .3,
        color: 'rgba(255,255,255, .4)',
        //color: 'random',
        clearOffset: .3
    });
</script>
</body>
</html>