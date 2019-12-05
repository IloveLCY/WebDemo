<%@page import="com.geminno.pojo.Emp"%>
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
    
    <title>My JSP 'modifyEmp.jsp' starting page</title>
    
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
			var modifyFlag = document.getElementById("modifyFlag");
			if(modifyFlag.value=='true'){
				alert('修改成功');
				window.opener.location.reload();
				window.close();
			}else if(modifyFlag.value=='false'){
				alert('修改失败');
			}
		}
		
	</script>
  </head>
  
  <body>
  	<%
  		Emp emp = (Emp)request.getAttribute("emp");
  	%>
    <center>
    	<div>
    		<input type="hidden" id="modifyFlag" value="<%=request.getAttribute("modifyFlag") %>">
    		
    	</div>
    	<form action="/WebDemo/empAction/empAction_modifyemp.action">
    		<input type="hidden" id="empId" name="empId" value="<%=emp.getEmpId()%>">
    		<input type="hidden" id="empNo" name="empNo" value="<%=emp.getEmpNo()%>"/>
    		<table border="1" align="center">
    			<tr>
	                 <td >员工编号：</td>
	                 <td >
	                 	<%=emp.getEmpNo()%>
	                 </td>
	             </tr>
	             <tr>
	                 <td >员工姓名：</td>
	                 <td >
	                 	<input type="text" id="empName" name="empName" value="<%=emp.getEmpName() %>"placeholder="<%=emp.getEmpName() %>"/>
	                 </td>
	             </tr>
	             <tr >
	                 <td>性别：</td>
	                 <td>
	                 	 <%
	                 	 	if(emp.getSex()){
	                 	 		%>
	                 	 		<input type="radio" name="sex" id="male" value="1" checked>男
	                     		<input type="radio" name="sex" id="famale" value="0" >女
	                 	 		<%
	                 	 	}else{
	                 	 		%>
	                 	 		<input type="radio" name="sex" id="male" value="1" >男
	                     		<input type="radio" name="sex" id="famale" value="0" checked>女
	                 	 		<%
	                 	 	}
	                 	 %>
	                     
	                 </td>
	             </tr>
	             <tr>
	                 <td >工资：</td>
	                 <td >
	                 	<input type="text" id="salary" name="salary" value="<%=emp.getSalary() %>" placeholder="<%=emp.getSalary() %>"/>
	                 </td>
	             </tr>
	             <tr>
	                 <td >出生日期：</td>
	                 <td >
	                 	<input type="text" id="birthday" name="birthday" value="<%=emp.getBirthday() %>" placeholder="<%=emp.getBirthday() %>"/>
	                 </td>
	             </tr>
           
            		<tr >
	                 <td>部门：</td>
	                 <td>
	                     <select name="deptId">
	                         <option>请选择</option>
	                         <% 
				             	List<Dept>deptList = (List<Dept>)request.getAttribute("deptList");
				             	for(Dept dept:deptList){
				             		if(dept.getDeptId().equals(emp.getDept().getDeptId())){
				             			%>
				             				<option value="<%= dept.getDeptId()%>" selected><%= dept.getDeptName()%></option>
				             			<%
				             		}else{
				             			%>
				             				<option value="<%= dept.getDeptId()%>"><%= dept.getDeptName()%></option>
				             			<%
				             		}
				             	}
				             %>
	                     </select>
	                 </td>
	             </tr>
            	
            
	            
	             <tr align="center" >
	                 <td colspan="2">
	                     <input type="submit" name="sub" value="修改"/>
	                     <input type="reset" value="重置">
	                 </td>
	             </tr>
    		
    		
    		
    		</table>
    	</form>
    </center>
  </body>
</html>
