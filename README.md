����һ��webdemo��ʵ�ֵĹ����Ƕ�Ա����Ϣ����ɾ�Ĳ�
������Ϊtomcat8.0 ���ݿ�Ϊmysql5.3 ��������Ϊjava

���ݿ���������emp(Ա��)��dept(����)
����emp�е�empIdΪ������deptIdΪ���
dept�е�deptIdΪ����

��һ�� ����JDBCUtil�� �޸Ĳ����ӱ��ص�mysql��
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/**?useUnicode=true&characterEncoding=UTF8";//*������д���ݿ���
	private static final String USER = "***";//�˴���д���ݿ��û���
	private static final String PSD = "****";//�û�������

	ͨ��public static Connection getConnection()�����������ݿ�

�ڶ��� ��������pojo��������������emp(Ա��)��dept(����)�����ݿ��е����Ժ�get��set����

������ ����dao��Ľӿ�(IEmpDAO��IDeptDAO)��������ɾ�Ĳ�ķ���������ʵ����(EmpDAOImpl��DeptDAOImpl)ʵ��

���Ĳ� ����service��ӿ�(IEmpBiz��IDeptBiz) ��Ӧcontroller�㹦�ܵķ���������ʵ����(EmpBizImpl��DeptBizImpl)ʵ��

���岽 ��д��EmpActionʵ��controller�Ĺ��ܣ�����struts.xml��ע�᷽�����������������ʱֻ��֪������������

������ ��дҳ���ļ�:��ʾ�Ͳ���Ա����Ϣ(main.jsp)�����Ա��(addEmp.jsp)���޸�Ա����Ϣ(modifyEmp.jsp)��ɾ��Ա��(deleteEmp.jsp)

���߲� ����Ŀ����tomcat��

���߲� ���ԣ���tomcat������ ������ַhttp://localhost:8080/WebDemo/empAction/empAction_tomain ��ʾҳ�漴Ϊ�ɹ�