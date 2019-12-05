<%@page import="com.geminno.pojo.PageBean"%>
<%@page import="com.geminno.pojo.EmpQuery"%>
<%@page import="com.geminno.dao.impl.DeptDAOImpl"%>
<%@page import="com.geminno.dao.impl.EmpDAOImpl"%>
<%@page import="com.geminno.pojo.Emp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/main.js"></script>
  </head>
  
  <body>
  	<center>
  		<% 
  			EmpQuery empQuery = (EmpQuery)request.getAttribute("empQuery");
  		%>
	  	<input type="hidden" id="modifyFlag" value="<%=request.getAttribute("modifyFlag")%>"/>
	  
	    <input type="hidden" id="deleteFlag" value="<%=request.getAttribute("deleteFlag")%>"/>
	  
	  	<div id="pageBar" style="width:600px; margin:0px auto; border:0px solid red;">
	  	<form id="queryForm" action="/WebDemo/empAction/empAction_tomain.action" method="post">
			<input type="hidden" id="curPage" name="curPage" value="1"/>
			员工编号:<input name="empNo" value="<%=empQuery.getEmpNo()==null?"":empQuery.getEmpNo()%>"/> 
			员工姓名：<input name="empName" value="<%=empQuery.getEmpName()==null?"":empQuery.getEmpName()%>"/>
			<br /><br />
			生      日: <input name="begin"  value="<%=empQuery.getBeginDate()==null?"":empQuery.getBeginDate()%>"/>
			  ~ <input name="end"  value="<%=empQuery.getEndDate()==null?"":empQuery.getEndDate()%>"/>
			<br />
		</form>
		</div>
	  	<div style="width:600px; margin:0px auto;">
	  		<a href="javascript:submitQuery(1)">查找</a>
	  	</div>
  		<a href="javascript:void(window.open('/WebDemo/empAction/empAction_toaddemp'));">添加</a>
	    <table border="1" width="600" align="center" >
	    	<tr>
	    		<td><input type="checkbox" id="checkall" onclick="oncheck();">全选</td>
	    		<td>编号</td>
	    		<td>姓名</td>
	    		<td>性别</td>
	    		<td>工资</td>
	    		<td>出生日期</td>
	    		<td>部门</td>
	    		<td>修改</td>
	    		<td>删除</td>
	    	</tr>
	     	<% 
	    	PageBean pageBean = (PageBean)request.getAttribute("pageBean");
	    		for (Object obj : pageBean.getData()) {
	    			Emp emp = (Emp)obj;
	    	%>
	    	<tr>
	    		<td><input type="checkbox" name="check"></td>
	    		<td><%=emp.getEmpNo() %></td>
	    		<td><%=emp.getEmpName() %></td>
	    		<td><%=emp.getSex()?"男":"女" %></td>
	    		<td><%=emp.getSalary() %></td>
	    		<td><%=emp.getBirthday() %></td>
	    		<td><%=emp.getDept()==null?"":emp.getDept().getDeptName() %></td>
	    		<td><a href="javascript:void(window.open('/WebDemo/empAction/empAction_tomodifyemp.action?empId=<%=emp.getEmpId() %>'));">修改</a></td>
	    		<td><a href="javascript:" onclick="isConfirm(this)" id="<%=emp.getEmpId() %>">删除</a></td>
	    	</tr>
	    	<% 
	    		}    	
	    	%>
	    </table>
	    <div id="pageBar" style="width:600px; margin:0px auto; border:0px solid red;">
		<a href="javascript:submitQuery(1)">首页</a>
		<%
			if(pageBean.getCurPage()>1){
				%>
					<a href="javascript:submitQuery(<%=pageBean.getCurPage()-1%>)">上一页</a>
				<%
			}else{
				%>
					上一页
				<%
			}
		%>
		<a>当前<%=pageBean.getCurPage() %>/<%=pageBean.getPageCount()%>页</a>
		<%
			if(pageBean.getCurPage()<pageBean.getPageCount()){
				%>
					<a href="javascript:submitQuery(<%=pageBean.getCurPage()+1%>)">下一页</a>
				<%
			}else{
				%>
					下一页
				<%
			}
		%>
		<a href="javascript:submitQuery(<%=pageBean.getPageCount()%>)">尾页</a>
	</div>
    </center>
  </body>
</html>
