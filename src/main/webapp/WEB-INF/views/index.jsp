<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
  Created by IntelliJ IDEA.
  User: qxg
  Date: 17-5-14
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String projectPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    String staticPath = projectPath + "/static";
%>
<%--项目路径 --%>
<c:set var="ctx" value="<%=projectPath%>"></c:set>
<%--静态资源路径 --%>
<c:set var="ctxsta" value="<%=staticPath%>"></c:set>


<html>
<head>
    <title>临时pad</title>
    <link href="${ctxsta}/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <div style="width:80%;margin:0 auto;padding:20px;">
        <textarea id="text" style="width: 100%;height: 850px;resize: none;">${text}</textarea>
        <br>
        <br>
        <button id="update" class="btn btn-warning" style="width:100px;">更新</button>
    </div>
</body>
<script src="${ctxsta}/js/jquery.min.js"></script>
<script src="${ctxsta}/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function(){
        $("#update").click(function(){
            //进行更新
            var text = $("#text").val();
            $.ajax({
                url:'${ctx}/update',
                type:'post',
                data:{
                    'text':text
                },
                success:function(result){
                    if(result["success"] == true){
                        alert("更新成功");
                    }else{
                        alert("更新失败");
                    }
                },
                error:function(error){
                    alert("出现错误");
                }
            });
        });
    });
</script>
</html>
