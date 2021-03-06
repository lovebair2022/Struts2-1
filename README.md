# Struts2

## Struts2_01 ##

### 1.为什么要学习Struts2 ###

以前MVC架构


<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/1.%E4%B8%89%E5%B1%82%E6%9E%B6%E6%9E%84MVC.bmp)</center>


strut2在以前MVC架构中所处的位置

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/2.Strut2.bmp)</center>
	
因此，Strut2是为了固定编码步骤，提高编码效率。
	
框架都是半成品，因此Strut2也是半成品，我们使用Strut2来提高我们的项目的生产效率



### 2.开发人员用Struts2天天写什么？ ###

1、控制器：核心组件（框架提供的：不用我们来做）

	Servlet VS. Filter

	Servlet:（控制器）
	1、每一个Servlet内存中唯一。
	2、load-on-startup就可以使Servlet在启动时就完成初始化
	3、用户的每次请求都会经过void service(request,response)
	4、配置映射为/*时，所有的请求都会经过该Servlet

	Filter：（控制器）
	1、每一个Filter内存中唯一。
	2、启动时就完成初始化
	3、用户的每次请求都会经过void doFIlter(request,response)
	4、配置映射为/*时，所有的请求都会经过该过滤器
	
	不同：过滤器要比Servlet强大，过滤器有权利决定是否放行。
	总结：Servlet能做的，Filter都能做。

	Strut的核心是Servlet
	Strut2是Filter

2、配置文件：指挥控制器运作（日后经常写）

3、动作类：处理逻辑（日后经常写）

4、JSP：展现结果（日后经常写）
	




### 3.Struts2的历史 ###


由传统Struts1和WebWork两个经典框架发展而来

Strust2 核心功能

	* 允许POJO（Plain Old Java Objects）对象 作为Action
	* Action的execute 方法不再与Servlet API耦合，更易测试
	* 支持更多视图技术（JSP、FreeMarker、Velocity）
	* 基于Spring AOP思想的拦截器机制，更易扩展
	* 更强大、更易用输入校验功能



 
### 4.搭建Struts2的开发环境 ###

1、拷贝jar包

	参考发行包中的struts2-blank.war中的jar

	Struts运行必要jar包

	   struts2-core-2.3.1.1.jar：Struts 2框架的核心类库
	   xwork-core-2.3.1.1.jar：Command模式框架,WebWork和Struts2都基于xwork 
	   ognl-3.0.3.jar：对象图导航语言(Object Graph Navigation Language), struts2框架通过其读写对象的属性
	   freemarker-2.3.18.jar：Struts 2的UI标签的模板使用FreeMarker编写
	   commons-logging-1.1.x.jar：ASF出品的日志包，Struts 2框架使用这个日志包来支持Log4J和JDK 1.4+的日志记录。
	   commons-fileupload-1.2.2.jar： 文件上传组件，2.1.6版本后需要加入此文件
	   commons-io-2.0.1.jar：传文件依赖的jar包
	   commons-lang-2.5.jar：对java.lang包的增强
	 
2、配置核心过滤器（控制器）

	参考发行包中的struts2-blank.war中的web.xml
    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

 
3、建立struts.xml的配置文件，放在应用的类路径的顶端（开发中：src目录下）

参考发行包中的struts2-blank.war中的struts.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE struts PUBLIC
		"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
		"http://struts.apache.org/dtds/struts-2.3.dtd">
	
	<struts>
		<!-- 开启开发模式 -->
	    <constant name="struts.devMode" value="true" />
	</struts>
 

验证是否成功：部署到Tomcat中，启动，只要没有报错，就是OK。


4.写struts配置文件里写标签没有提示的问题

	1.文件可以在strut2-core-2.3.15.3.jar文件里去找strut2-2.3.dtd

	2.找到dtd，放到某一个目录中。WEB-INF/dtd

	3.在项目的配置Preferences里的xml catalog去让dtd的文件目录关联到strut2.xml里的url:https://struts.apache.org/dtds/struts-2.3.dtd


5.具体看项目day26_01_struts2HelloWorld

### 5.Struts2的执行流程全图（面试） ###

>版本1：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/4.strut2procedure.jpg)</center>

>版本2：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/5.strut2procedure2.bmp)</center>

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/6.strut2procedure3.bmp)</center>
 
 
Struts2的工作流程:

	1：客户端提交一个HttpServletRequest请求，（.action或JSP页面)

	2：请求被提交到一系列的Filter过滤器，如ActionContextCleanUp和FileterDispather等。

	3：FilterDispatcher是Struts2的控制核心，它通常是过滤器链中的最后一个过滤器。

	4：请求发到FilterDispathcher后，FilterDispatcher询问ActionMapper是否需要调用某个Action来处理这个Request（一般根据URL后缀是否为.action来判断）

	5：如果ActionMapper决定需要调用某个Action，FilterDispatcher则把请求交到ActionProxy,由其进行处理。

	6：ActionProxy通过ConfigurationManager（它会访问Struts.xml询问创建的配置文件，找到需要调用的Action类）

	7：ActionProxy创建一个ActionInvocation实例，而ActionInvocation通过代理模式调用Action（在调用之后会根据配置文件加载相关的所有Interceptor拦截器）

	8：Action执行完毕后，返回一个result字符串，此时再按相反的顺序通过Interceptor拦截器

	9：最后ActionInvocation负责根据struts.xml中配置的result，决定进行下一步输出


简化版：

	1：客户端初始化一个指向Servlet容器的请求

	2：请求经过系列过滤器，FilterDispatcher被调用

	3：ActionMapper决定需要调用某个Action，FilterDispatcher把请求的处理交给ActionProxy

	4：ActionProxy通过ConfigurationManager询问框架的配置文件找到需要调用的Action类

	5：ActionProxy创建一个ActionInvocation实例

	6：ActionInvocation调用、回调Action的execute方法

	7：Action执行完毕ActionInvocation，根据struts.xml配置找到对应的返回结果


### 6.Struts2的配置文件和加载顺序 ###

1、default.properties 该文件保存在 struts2-core-2.3.7.jar 中 org.apache.struts2中

2、struts-default.xml 该文件保存在 struts2-core-2.3.7.jar

3、struts-plugin.xml 该文件保存在struts-Xxx-2.3.7.jar（struts2的插件jar包中）

4、struts.xml 该文件是web应用默认的struts配置文件（程序员写）

5、struts.properties 该文件是Struts的默认配置文件（程序员写）。构建路径的顶端

6、web.xml应用的配置文件

按照从1到6的顺序加载配置文件。后面的内容会覆盖前面的内容。
1和2和3都在框架或插件提供的jar中，不需要我们直接改。


### 7.struts.xml配置文件的内容标签 ###

1、package：

作用：分模块化开发。
属性：

	name：包的名称。唯一。必须的

	extends：一般都需要直接或间接继承一个叫做struts-defaul
	（struts-default.xml中有定义）的包名。因为，struts框架的一些核心功能配置都在此处。

	abstract：如果为true，说明是一个抽象包。说明让别人去继承。没有任何action子元素的包就可以定义为抽象包。

	namespace：名称空间。一般以"/"开头，和动作名称一起，构成了用户的访问路径。

比如：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/7.namespace.bmp)</center>
 

专题：package中的namesapce属性(难点)

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/8.namespacetopic.bmp)</center>

2、action：

作用：配置动作。用户什么请求，执行哪个类，及哪个类的方法。

属性：

	name：动作名称。必须的。包中要唯一。

	class:动作类的全名。可以不指定，默认值是com.opensymphony.xwork2.ActionSupport

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/9.actionsupport.bmp)</center>
	 
	method：执行的动作类的动作方法。可以不指定，默认值是execute。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/10.execute.bmp)</center>	 

说明：可以覆盖掉默认的动作类。一般我们不需要这么做。
 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/11.cover.bmp)</center>	 

3、constant配置：

推荐覆盖常量办法：在struts.xml中使用constant标签。

作用：配置常量的值。

struts2的常量都在default.properties配置文件中做了定义（struts2-core.jar/  org.apache.struts2包中）

常用的常量：

	struts.i18n.reload = true 国际化配置文件更改后，自动加载。

	struts.configuration.xml.reload = true struts配置文件更改后，自动加载

	struts.devMode = false 如果为true，开启开发模式 .实际运行应该为false

	struts.i18n.encoding=UTF-8 应用使用的编码。

	struts.action.extension=action,,  struts2框架真正执行的url地址后缀。多个用逗号分隔

	struts.serve.static.browserCache=true 静态资源告知浏览器不要缓存。(Expires:-1;Cache-Control:no-cache;Pragma:no-cache)

4、包含其他的配置文件

	<include file="user.xml"></include>
	



### 8.动作类：Action ###

1、编写动作类的方式

	方式一：动作类就是一个POJO。可以不用继承或实现任何的类或接口。

	方式二：动作类实现com.opensymphony.xwork2.Action接口。

		SUCCESS：一切正常时使用
		NONE：不转向任何视图时使用（文件下载时）
		ERROR：出错（异常中）
		INPUT：数据回显时。
		LOGIN：转向登录页面时。

	(推荐的)方式三：动作类继承ActionSupport类。

2、动作方法：

	编写要求：
	必须是public的方法必须返回String的值。如果为null，则不转向任何的视图
	方法没有任何的参数

3、动作方法的映射：

	如果代码的方法没有约定好，我们的配置文件代码会非常的多

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/12.avoidthiscondition.bmp)</center>	

	但是如上的配置可以使用通配符来代替，这样可以节省配置文件的代码量，提高效率 

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/13.tongpeif1.bmp)</center>


	另外一种更高效的代码规范配置，如下，比如以个action的名称为add_Customer，那么第一个*就代表add，第二个*就代表Customer，那{1}就代表add，那{2}就代表Customer。所以规范代码可以大大减少配置的效率	

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/14.tongpeif2.bmp)</center>	

	总的来说。真正开发时还是少用通配符，以免引起其他开发者的不解，因为这样配置不直观，不容易理解。
 
 
4、DMI：Dynamic Method Invocation（动态方法调用）（了解）
当前配置：没有指定动作方法

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/15.nodmi1.bmp)</center>
 
url：customer!addCustomer

错误：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/16.nodmi2.bmp)</center>
 
说明struts2框架默认是不允许执行动态方法调用的。如果要用，需要配置一个常量：

	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
 

危险：容易把动作方法暴露给客户端

5、默认的action



详情参考项目day26_02_struts2Action


 

### 9.Servlet规范相关实例的获取 ###

1、Struts2的一大特点：与ServletAPI解耦了。

2、获取Servlet有关的类
	
	方式一：（暂时记住。推荐的）

		public class Demo1Action extends ActionSupport {
			public String execute(){
				ServletActionContext.getPageContext();
				ServletActionContext.getRequest();
				ServletActionContext.getResponse();
				ServletActionContext.getServletContext();
				return NONE;
			}
		}

	 
	方式二：（麻烦。框架注入进来）实现接口
	
		//演示Servlet有关的对象的获取
		public class Demo2Action extends ActionSupport implements ServletRequestAware,ServletResponseAware {
			private HttpServletRequest request;
			private HttpServletResponse response;
			public String execute(){
				System.out.println(request);
				System.out.println(response);
				return NONE;
			}
			//在调用动作方法前，框架先调用该方法。把request对象注入进来
			public void setServletRequest(HttpServletRequest request) {
				 this.request = request;
			}
			public void setServletResponse(HttpServletResponse response) {
				this.response = response;
			}
		}
		 
		原理：怎么做到的？实际上是一个拦截器来做的。（在执行动作方法之前先会执行拦截器）
		<interceptor name="servletConfig" class="org.apache.struts2.interceptor.ServletConfigInterceptor"/>

		//拦截器
		public class ServletConfigInterceptor extends AbstractInterceptor implements StrutsStatics {
		
		    private static final long serialVersionUID = 605261777858676638L;
		
		    public String intercept(ActionInvocation invocation) throws Exception {
		        final Object action = invocation.getAction();//得到当前的动作类
		        final ActionContext context = invocation.getInvocationContext();
		
		        if (action instanceof ServletRequestAware) {//判断当前的动作有没有实现ServletRequestAware这个接口
		            HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		            ((ServletRequestAware) action).setServletRequest(request);
		        }
		
		        if (action instanceof ServletResponseAware) {
		            HttpServletResponse response = (HttpServletResponse) context.get(HTTP_RESPONSE);
		            ((ServletResponseAware) action).setServletResponse(response);
		        }
		
		        if (action instanceof ParameterAware) {
		            ((ParameterAware) action).setParameters((Map)context.getParameters());
		        }
		
		        if (action instanceof ApplicationAware) {
		            ((ApplicationAware) action).setApplication(context.getApplication());
		        }
		        
		        if (action instanceof SessionAware) {
		            ((SessionAware) action).setSession(context.getSession());
		        }
		        
		        if (action instanceof RequestAware) {
		            ((RequestAware) action).setRequest((Map) context.get("request"));
		        }
		
		        if (action instanceof PrincipalAware) {
		            HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		            if(request != null) {
		                // We are in servtlet environment, so principal information resides in HttpServletRequest
		                ((PrincipalAware) action).setPrincipalProxy(new ServletPrincipalProxy(request));
		            }
		        }
		        if (action instanceof ServletContextAware) {
		            ServletContext servletContext = (ServletContext) context.get(SERVLET_CONTEXT);
		            ((ServletContextAware) action).setServletContext(servletContext);
		        }
		        return invocation.invoke();
		    }
		}
		
			
			
		


 
### 10.Struts2中的结果视图 ###

1、展现结果

通过struts.xml中result配置来管理的。

	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE struts PUBLIC
		"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
		"http://struts.apache.org/dtds/struts-2.3.dtd">
	
	<struts>
		<!-- 开启开发模式 -->
	    <constant name="struts.devMode" value="true" />
	    <package name="p1" extends="struts-default">
	    	<action name="act1">
	<!--     		<result type="chain">act2</result> -->
	    		<result type="chain">
	    			<!-- 相当于：调用chain对应的类的setActionName("act2")方法 -->
	    			<param name="namespace">/user</param>
	    			<param name="actionName">act2</param>
	    		</result>
	    	</action>
	    
	    	<action name="save" class="com.itheima.action.Demo1Action" method="save">
	    		<result name="success">
	    			<param name="location">/success.jsp</param>
	    		</result>
	    		<result name="error">/error.jsp</result>
	    	</action>
	    	
	    </package>
	    <package name="p2" namespace="/user" extends="struts-default">
	    	<action name="act2">
	    		<result type="plainText">/demo.jsp</result>
	    	</action>
	    </package>
	</struts>



	public class Demo1Action extends ActionSupport {
		public String save(){
			//调用service
			try{
	//			int i=1/0;
				return SUCCESS;
			}catch(Exception e){
				e.printStackTrace();
				return ERROR;
			}
		}
	}


2、result元素<result>

作用：配置一个结果视图

属性：

	name：逻辑视图名称。对应的是动作方法的返回值。可以不写。默认值是success。

	type：指定结果类型。默认值是dispatcher,就是转发。

问题：dispatcher从哪里来的？struts-default.xml中有定义。

	<result-types>
	    <result-type name="chain" class="com.opensymphony.xwork2.ActionChainResult"/>
	    <result-type name="dispatcher" class="org.apache.struts2.dispatcher.ServletDispatcherResult" default="true"/>
	    <result-type name="freemarker" class="org.apache.struts2.views.freemarker.FreemarkerResult"/>
	    <result-type name="httpheader" class="org.apache.struts2.dispatcher.HttpHeaderResult"/>
	    <result-type name="redirect" class="org.apache.struts2.dispatcher.ServletRedirectResult"/>
	    <result-type name="redirectAction" class="org.apache.struts2.dispatcher.ServletActionRedirectResult"/>
	    <result-type name="stream" class="org.apache.struts2.dispatcher.StreamResult"/>
	    <result-type name="velocity" class="org.apache.struts2.dispatcher.VelocityResult"/>
	    <result-type name="xslt" class="org.apache.struts2.views.xslt.XSLTResult"/>
	    <result-type name="plainText" class="org.apache.struts2.dispatcher.PlainTextResult" />
	</result-types>


 
3、常用的结果视图的类型(属性type)

dispatcher:默认结果类型。请求转发到一个页面。

redirect：请求重定向到一个页面。

chain:请求转发到另一个动作。
 
    <package name="p1" extends="struts-default">
	    	<action name="act1">
				<result type="chain">act2</result>
	    	</action>
	    
	    	<action name="save" class="com.itheima.action.Demo1Action" method="save">
	    		<result name="success">/success.jsp</result>
	    		<result name="error">/error.jsp</result>
	    	</action>
	    	
	    </package>

	访问url：http://localhost:8080/day26_03_struts2Results/act1

redirectAction：重定向到另外一个动作

stream：下载用的（文件上传和下载时再议）

plainText：以纯文本的形式展现内容


## Struts2_02 ##

### 1.自定义结果类型 ###

项目：day27_00_struts2Results

1、编写一个类，实现com.opensymphony.xwork2.Result接口。

	public class CaptchaResult implements Result {
 
	在该方法中可以拿到ServletAPI去完成你的功能

2、声明自定义的结果类型：先声明后使用

	<struts>
		<!-- 开启开发模式 -->
	    <constant name="struts.devMode" value="true" />
	    <package name="mystruts-default"  extends="struts-default">
	    	<!-- 声明结果类型 -->
	    	<result-types>
	    		<result-type name="captcha" class="com.itheima.results.CaptchaResult"></result-type>
	    	</result-types>
	    </package>
	    <package name="p1" extends="mystruts-default">
	    	<action name="captcha">
	    		<result name="success" type="captcha">
	    			<!-- 给结果类型注入参数
	    			<param name="height">10</param>
	    			<param name="width">3</param>
	    			 -->
	    		</result>
	    	</action>
	    </package>
	    
	</struts>
 
3、使用

	<package name="p1" extends="mystruts-default">
		<action name="captcha">
			<result name="success" type="captcha">
				<!-- 给结果类型注入参数
				<param name="height">10</param>
				<param name="width">3</param>
				 -->
			</result>
		</action>
	</package>
 
	访问url：http://localhost:8080/day27_00_struts2Results/01login.jsp

小技巧：自定义的结果视图，大家都要用时

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/17.customresult.png)</center>	 
 
### 2.封装请求参数（很重要） ###

>使用框架的意义：提升开发效率。节省的时间去研究业务。

2.1封装请求参数的方式：

	1、用动作类作为模型对象，直接封装请求参数

		a、通过配置文件注入静态（不变）参数

		    <package name="p1" extends="struts-default">
		    	<action name="act1" class="com.itheima.action.PersonAction">
		    		<!-- Person.setNickname("游客") -->
		    		<param name="nickname">游客</param>
		    	</action>
		    </package> 

		注：静态参数注入是由一个名字为staticParams拦截器完成的，该拦截器在struts-default.xml里定义。

		b、注入动态（用户输入的<通过jsp里的表单输入的参数>）参数

		    <form action="${pageContext.request.contextPath}/act1" method="post">
		    	用户名：<input type="text" name="username"/><br/>
		    	密码：<input type="text" name="password"/><br/>
		    	昵称：<input type="text" name="nickname"/><br/>
		    	<input type="submit" value="注册"/>
		    </form>

			public class PersonAction extends ActionSupport{
				private String username;
				private String password;
				private String nickname;
				public String getUsername() {
					return username;
				}
				public void setUsername(String username) {
					this.username = username;
				}
				public String getPassword() {
					return password;
				}
				public void setPassword(String password) {
					this.password = password;
				}
				public String getNickname() {
					return nickname;
				}
				public void setNickname(String nickname) {
					this.nickname = nickname;
				}
				public String execute() throws Exception {
					System.out.println(username+":"+password+":"+nickname);
					return NONE;
				}
				
			}
		 
		编写原则：表单的输入域的名称和动作类中的属性名（getter和setter）保持一致。
		注：动态参数注入是由一个名字为params拦截器完成的。

	2、动作类和模型对象分离
 
		//模型
		public class Student {
			private String username;
			private String password;
			private String nickname;
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getNickname() {
				return nickname;
			}
			public void setNickname(String nickname) {
				this.nickname = nickname;
			}
			@Override
			public String toString() {
				return "Student [username=" + username + ", password=" + password
						+ ", nickname=" + nickname + "]";
			}
			
		}

		
		//动作类
		public class StudentAction {
			private Student student = new Student();//效率相对要高一些
		
			public Student getStudent() {
				System.out.println("getStudent");
				return student;
			}
		
			public void setStudent(Student student) {
				System.out.println("setStudent");
				this.student = student;
			}
			public String save(){
				//把表单的数据封装到模型对象中
				//调用Service把Student的数据保存到数据库中
				System.out.println(student);
				return "none";
			}
		}


		//配置
    	<action name="act2" class="com.itheima.action.StudentAction" method="save"/>


		//页面
		<form action="${pageContext.request.contextPath}/act2" method="post">
			用户名：<input type="text" name="student.username"/><br/>
			密码：<input type="text" name="student.password"/><br/>
			昵称：<input type="text" name="student.nickname"/><br/>
			<input type="submit" value="注册"/>
		</form>

		总结：框架会探测student这个模型是否为空，如果为空，注入他的实例，分别调用该对象的属性，注入值。

	3、（模型和动作分开）模型驱动：ModelDriven

		public class Customer {
			private String username;
			private String password;
			private String nickname;
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getNickname() {
				return nickname;
			}
			public void setNickname(String nickname) {
				this.nickname = nickname;
			}
			@Override
			public String toString() {
				return "Customer [username=" + username + ", password=" + password
						+ ", nickname=" + nickname + "]";
			}
			
		}


		public class CustomerAction implements ModelDriven<Customer>{
			private Customer customer = new Customer();//一定要new出来
		
			public Customer getCustomer() {
				return customer;
			}
		
			public void setCustomer(Customer customer) {
				this.customer = customer;
			}
			public String save(){
				System.out.println(customer);
				return "none";
			}
			//调用动作方法前，框架会先调用该方法
			//不会实例化customer。
			public Customer getModel() {
				return customer;
			}
		}


	    <form action="${pageContext.request.contextPath}/act3" method="post">
	    	用户名：<input type="text" name="username"/><br/>
	    	密码：<input type="text" name="password"/><br/>
	    	昵称：<input type="text" name="nickname"/><br/>
	    	<input type="submit" value="注册"/>
	    </form>




	注：实际上是一个名字为modelDriven拦截器完成的。该拦截器会在调用动作方法前，调用getModel(),得到模型对象，他接着把该模型对象压到了值栈的栈顶。表单的username的值，框架就会调用栈顶对象的setUsername方法。（此处暂时记住）。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/18modelDriven.png)</center>

	关键点：实现ModelDriven接口；模型对象要自己实例化；

2.2封装集合或Map的数据（用的较少）

	a、封装集合，批量添加时用

		public class Demo1Action {
			//批量添加时
			private Collection<Student> stus = new ArrayList<Student>();
		
			public Collection<Student> getStus() {
				return stus;
			}
		
			public void setStus(Collection<Student> stus) {
				this.stus = stus;
			}
			public String save(){
				for(Student s:stus){
					System.out.println(s);
				}
				return "none";
			}
		}

		//在表单里批量添加数据
	    <form action="${pageContext.request.contextPath}/act4" method="post">
	    	用户名：<input type="text" name="stus[0].username"/><br/>
	    	密码：<input type="text" name="stus[0].password"/><br/>
	    	昵称：<input type="text" name="stus[0].nickname"/><br/>
	    	<hr/>
	    	用户名：<input type="text" name="stus[1].username"/><br/>
	    	密码：<input type="text" name="stus[1].password"/><br/>
	    	昵称：<input type="text" name="stus[1].nickname"/><br/>
	    	<input type="submit" value="注册"/>
	    </form>

	 
	b、封装到Map中，批量添加时用

		public class Demo2Action {
			//批量添加时
			private Map<String, Student> stus = new HashMap<String, Student>();
		
			
			public Map<String, Student> getStus() {
				return stus;
			}
		
		
			public void setStus(Map<String, Student> stus) {
				this.stus = stus;
			}
		
		
			public String save(){
				for(Map.Entry<String, Student> me:stus.entrySet()){
					System.out.println(me.getKey()+":"+me.getValue());
				}
				return "none";
			}
		}

		//在表单里批量添加数据
	    <form action="${pageContext.request.contextPath}/act5" method="post">
	    	用户名：<input type="text" name="stus['s1'].username"/><br/>
	    	密码：<input type="text" name="stus['s1'].password"/><br/>
	    	昵称：<input type="text" name="stus['s1'].nickname"/><br/>
	    	<hr/>
	    	用户名：<input type="text" name="stus['s2'].username"/><br/>
	    	密码：<input type="text" name="stus['s2'].password"/><br/>
	    	昵称：<input type="text" name="stus['s2'].nickname"/><br/>
	    	<input type="submit" value="注册"/>
	    </form>

### 3.类型转换（明白，开发中几乎不写） ###

1、用户所有的输入都是字符串

2、显示出来的都是字符串

	总结：类型转换。String--->其他类型（存数据时）；其他类型----->字符串（显示数据时）
	
	Struts2中的类型转换器的继承体系

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/19convertorSystem.png)</center>

3、自定义类型转换器

	a、编写一个类，继承StrutsTypeConverter

		//自定义类型转换器：
		//String--->java.util.Date   MM/dd/yyyy
		//java.util.Date----->String	MM/dd/yyyy
		public class MyDateConvertor extends StrutsTypeConverter {
			
			private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			//String--->java.util.Date   MM/dd/yyyy
			//values:用户输入的值
			//toClass:目标类型
			public Object convertFromString(Map context, String[] values, Class toClass) {
				if(toClass==Date.class){
					if(values!=null&&values.length>0){
						String sdate = values[0];
						try {
							return df.parse(sdate);
						} catch (ParseException e) {
							throw new RuntimeException(e);
						}
					}
				}
				return null;
			}
			//java.util.Date----->String	MM/dd/yyyy
			public String convertToString(Map context, Object o) {
				if(o instanceof Date){
					Date d = (Date)o;
					return df.format(d);
				}
				return null;
			}
		
		}

	 
	b、注册类型转换器
		
		b.1局部类型转换器：给某个动作用的

			在动作类所在的包中，建立一个“动作类名-conversion.properties”的配置文件，内容如下：
		 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/20personAction-conversion.properties.png)</center>

		b.2全局类型转换器：大家都来用

			在构建路径的顶端（WEB-INF/classes）目录下建立名称为xwork-conversion.properties的配置文件，按照要转换的目标类型进行转换器的配置。
		 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/21xwork-conversion.properties.png)</center>


4、转换失败时的数据回显和错误提示

	前提：动作类需要继承ActionSupport

	出现转换失败时，由一个名字为conversionError拦截器负责处理的。会把错误信息封装起来，并且转向一个叫做input的逻辑视图（用于回显数据）。

	更改默认的错误提示：

	在动作类的包中，建立一个“动作类名.properties”的配置文件（实际上是一个语言消息包），内容如下：
	 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/22errorTextProperties.png)</center>

### 4.数据校验（经常做） ###

参考项目：day27_03_struts2Validation

4.1校验的方式

	客户端校验：JavaScript
	服务器端校验：代码
	实际开发：客户端+服务器端校验

4.2Struts2的服务器校验

>前提：动作类需要继承ActionSupport

验证是由一个名字为validation（声明式校验）的拦截器、workflow（错误提示）完成的

	a、编程式校验：动作类中写代码
	
		a.1针对动作类中的所有动作方法进行校验

			在动作类中，覆盖掉validate方法，在方法里写校验逻辑

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/23validate.png)</center>
		 
		a.2针对动作类中的指定方法进行校验
	
			方式一：麻烦

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/24validateMethod1.png)</center>
			 
			方式二：使用注解，简单
		 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/25validateMethod2.png)</center>
	
	b、声明式校验（推荐）：写配置文件
	
		把校验规则和消息提示放到配置文件中。
	
		b.1针对动作类中的所有动作方法进行校验
	
			在动作类所在的包中，建立名字为"动作类名-validation.xml"的配置文件，内容如下：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/26validateMethod3.png)</center>
		 
		b.2针对动作类中的指定方法进行校验  
	
			方式一：简单。使用@SkipValidation注解
		
			方式二：麻烦。
			动作类名-动作别名(指struts.xml中动作的名称)-validation.xml

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/27validateMethod4.png)</center>
			 
		
>专题：Struts2框架提供的内置验证器

xwork-core-2.3.15.3.jar\com\opensymphony\xwork2\validator\validators\default.xml

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/28validateMethod5.png)</center>

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/29validateMethod6.png)</center>

		 
		b.3自定义声明式校验器
	
			a、编写一个类，继承FieldValidatorSupport，定义一个基于字段的验证器。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/30validateMethod7.png)</center>
			 
			b、定义验证器后才能使用。
			在WEB-INF/classes目录下，建立一个名称为validators.xml的配置文件，内容如下：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/31validateMethod8.png)</center>
			 
			c、日后就可以在声明式验证中使用了

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/32validateMethod9.png)</center>
	

## Struts2_03 ##

### 1.国际化（了解） ###

1、配置全局国际化消息资源包

	a、配置全局消息资源包
	 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/33struts_custom_i18n_resources.png)</center>

	b、如何访问
	
		1、在动作类中：

			前提，动作类继承ActionSupport
				
				public class Demo1Action extends ActionSupport {
				
					public String execute() throws Exception {
						String s = getText("hello");//没有意义
						System.out.println(s);
						return NONE;
					}
			 
		2、在页面中：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/34struts_custom_i18n_resources1.png)</center>
	 
			或者

				<s:text name="hello"></s:text>
	
		3、自由指定消息资源包，借助struts2的有关国际化的标签：

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/35struts_custom_i18n_resources2.png)</center>
	 
	
			如果消息资源包在com.itheima.resources.msg_zh_CN.properties

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/36struts_custom_i18n_resources3.png)</center>

 
2、配置局部消息资源包 

	一定要经过Action才行：
	书写规范：在动作类所在包中，建立名字”动作类名-zh-CN.properties”的配置文件。动作类中访问，发现局部的比全局的优先级高。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/37struts_custom_i18n_resources4.png)</center>
	
	 
3、包范围的消息资源包

	也得经过action访问 
	书写有规范的，名称为package_zh_CN.properties,放在类的包中。可以被包中及子包的所有动作类来访问。


总结：
 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/38struts_custom_i18n_resources5.png)</center>
	


### 2.Struts2中的拦截器（很重要AOP） ###

1、Struts2的很多核心功能都是由拦截器完成的。


	staticParam、params、conversionError、modelDriven、validation、workflow、servletConfig等 

2、在执行动作方法前或执行结果后，做拦截处理。AOP编程思想。

ObjectFactory：框架提供的默认的动作类创建工厂，返回的是动作类的代理子类。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/39struts2_interceptor1.png)</center>
 
3、自定义拦截器

	a、定义一个类，继承AbstractInterceptor或者实现Interceptor

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/40struts2_interceptor2.png)</center>
	 
	b、在struts.xml中进行定义
	 
<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/41struts2_interceptor3.png)</center>

	c、在动作中使用

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/42struts2_interceptor4.png)</center>
 
4、Struts2框架的拦截器继承体系

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/43struts2_interceptor5.png)</center>
 

### 3.文件的上传和下载（很重要，记住，拦截器和结果类型Stream实现的） ###

1、文件的上传是一个由fileUpload的拦截器实现的。

> 前提：method必须是post；enctype=multipart/form-data;提供type=file的上传输入域

2、单文件上传

	a、定义动作类

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/44upload1.png)</center>
	 
	b、拦截器的参数配置：

		maximumSize：限制上传文件的大小。优先级比全局那个要低

		<param name="fileUpload.allowedExtensions">.bmp,.jpg,.png</param>：限制的文件扩展名

		allowedTypes：限制上传文件的MIME类型。多个类型也是通过逗号分隔。

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/45upload2.png)</center>

3、多文件上传

	用数组或List

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/46upload3.png)</center>
 
4、参数配置及不符合要求时的错误提示

	a、如果出现上传失败的情况，框架自动转向一个input的逻辑视图。

	b、更改默认的消息提示：
	 
		在哪里？struts2-core.jar org.apache.struts2.struts-message.properties

		改变：配置一个全局消息资源包

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/47upload4.png)</center>
 
5、文件的下载：结果类型

	a、动作类

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/48download1.png)</center>

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/49download2.png)</center>
	  
	b、配置stream结果类型

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/50download3.png)</center>

 
### 4.OGNL表达式（很重要） ###

>具体看项目day28_03_struts2ognl

1、OGNL是Object Graphic Navigation Language（对象图导航语言）的缩写，
它是一个开源项目

2、OGNL相对其它表达式语言具有下面几大优势

	前提：在Struts2用OGNL表达式，需要用到标签。

	*	支持对象方法调用，如xxx.doSomeSpecial();
	*	支持类静态的方法调用和值访问
	*	支持赋值操作和表达式串联
	*	访问OGNL上下文（OGNL context）和ActionContext(很重要)
	*	操作集合对象


### 5.ValueStack(很简要) ###

1、ValueStack的声明周期

	每次动作访问都会创建一个ValueStack。动作类的实例声明周期也是每次访问时都创建。

2、ValueStack和ActionContext的关系

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/51valueStack1.png)</center>
 
	对于我们来说：
	
	通过ValueStack操作Map和栈(根)。
	
	具体看到这个值栈：<s:debug/>

<center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/52valueStack2.png)</center>
	 
	
	明确概念：OGNL的contextMap。ValueStack是作为他的一个叫做根（实际上是一个List）的形式存在的。

3、ValueStack常用的方法

	void set(String key,Object value):先获取根栈栈顶的Map，如果不存在，压入一个新的Map，把key和value放到这个Map中。如果存在，直接放key和value。


 <center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/53valueStack3.png)</center>

 <center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/54valueStack4.png)</center>
 
	void setValue(String ognlExp ,Object):String是一个OGNL表达式。如果表达式以#开头，操作contextMap。如果不是，设置根栈中对象的某个属性，从顶到尾依次搜寻


 <center>![](https://raw.githubusercontent.com/faithyee/Struts2/master/img/55valueStack5.png)</center>
 
	* Object findValue(String expr):参数是一个OGNL表达式。如果以#开头，从contextMap中找key值所对应的对象。如果不是以#开头，搜索根栈中对象的属性（getter方法）

	特别注意：如果编写的表达式不是以#开头，先搜索根栈对象的所有属性，如果没有找到，会把它当做key值到contextMap中找。

	* String findString(String expr):和findValue功能一样，但把OGNL表达式获取的对象转换成String



### 6.Struts2标签 ###