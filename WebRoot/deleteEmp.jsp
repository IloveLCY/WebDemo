<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteemp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		window.onload = function(){
			var deleteFlag = document.getElementById("deleteFlag");
			if(deleteFlag.value=='true'){
				alert('删除成功');
				window.opener.location.reload();
				window.close();
			}else if(deleteFlag.value=='false'){
				alert('删除失败');
				window.close();
			}
		}
	</script>
  </head>
  
  <body>
    <input type="hidden" id="deleteFlag" value="<%=request.getAttribute("deleteFlag") %>">
  </body>
</html>
