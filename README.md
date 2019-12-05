这是一个webdemo，实现的功能是对员工信息的增删改查
服务器为tomcat8.0 数据库为mysql5.3 开发语言为java

数据库有两个表emp(员工)和dept(部门)
其中emp中的empId为主键，deptId为外键
dept中的deptId为主键

第一步 设置JDBCUtil类 修改并连接本地的mysql库
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/**?useUnicode=true&characterEncoding=UTF8";//*部分填写数据库名
	private static final String USER = "***";//此处填写数据库用户名
	private static final String PSD = "****";//用户名密码

	通过public static Connection getConnection()方法连接数据库

第二步 分析设置pojo包，里面设置了emp(员工)和dept(部门)在数据库中的属性和get、set方法

第三步 设置dao层的接口(IEmpDAO和IDeptDAO)，定义增删改查的方法，并用实现类(EmpDAOImpl和DeptDAOImpl)实现

第四步 设置service层接口(IEmpBiz和IDeptBiz) 对应controller层功能的方法，并用实现类(EmpBizImpl和DeptBizImpl)实现

第五步 编写类EmpAction实现controller的功能，并在struts.xml中注册方法名，在浏览器访问时只需知道方法名即可

第六步 编写页面文件:显示和查找员工信息(main.jsp)、添加员工(addEmp.jsp)、修改员工信息(modifyEmp.jsp)、删除员工(deleteEmp.jsp)

第七步 将项目部署到tomcat中

第七步 测试，打开tomcat服务器 输入网址http://localhost:8080/WebDemo/empAction/empAction_tomain 显示页面即为成功