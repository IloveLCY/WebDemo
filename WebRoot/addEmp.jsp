<%@page import="com.geminno.pojo.Dept"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmp.jsp' starting page</title>
    
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
			var addFlag = document.getElementById("addFlag");
			if(addFlag.value=='true'){
				alert('添加成功');
				window.opener.location.reload();
			}else if(addFlag.value=='false'){
				alert('添加失败');
			}
		}
	</script>
  </head>
  
  <body>
    <center>
    	<div>
    		<input type="hidden" id="addFlag" value="<%=request.getAttribute("addFlag") %>">
    	</div>
    	<form action="/WebDemo/empAction/empAction_addemp.action">
    		<input type="hidden" name="addEmpToken" value="${requestScope.addEmpToken}">
    		<table border="1" align="center">
    			<tr>
	                 <td >员工编号：</td>
	                 <td >
	                 	<input type="text" id="empNo" name="empNo" />
	                 </td>
	             </tr>
	             <tr>
	                 <td >员工姓名：</td>
	                 <td >
	                 	<input type="text" id="empName" name="empName" />
	                 </td>
	             </tr>
	             <tr >
	                 <td>性&nbsp;&nbsp;&nbsp;别：</td>
	                 <td>
	                     <input type="radio" name="sex" id="male" value="1">男
	                     <input type="radio" name="sex" id="famale" value="0">女
	                 </td>
	             </tr>
	             <tr>
	                 <td >工资：</td>
	                 <td >
	                 	<input type="text" id="salary" name="salary" />
	                 </td>
	             </tr>
	             <tr>
	                 <td >出生日期：</td>
	                 <td >
	                 	<input type="text" id="birthday" name="birthday" />
	                 </td>
	             </tr>
           
            		<tr >
	                 <td>部门：</td>
	                 <td>
	                     <select name="deptId">
	                         <option >请选择</option>
	                         <% 
				             	List<Dept>deptList = (List<Dept>)request.getAttribute("deptList");
				             	for(Dept dept:deptList){
				             %>
				             <option value="<%= dept.getDeptId()%>"><%= dept.getDeptName()%></option>			
				             <%
				             	}
				             %>
	                     </select>
	                 </td>
	             </tr>
            	
            
	            
	             <tr align="center" >
	                 <td colspan="2">
	                     <input type="submit" name="sub" value="添加"/>
	                     <input type="reset" value="重置">
	                 </td>
	             </tr>
    		
    		
    		
    		</table>
    	</form>
    </center>
  </body>
</html>
