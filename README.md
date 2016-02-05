# Struts2

## Struts2_01 ##

1.为什么要学习Struts2

	以前MVC架构


<center>![](http://image17-c.poco.cn/mypoco/myphoto/20160205/21/17860070920160205215922061_640.jpg?985x400_160)</center>


	strut2在以前MVC架构中所处的位置

<center>![](http://image17-c.poco.cn/mypoco/myphoto/20160205/22/17860070920160205220710086_640.jpg?1071x521_160})</center>
	
	因此，Strut2是为了固定编码步骤，提高编码效率。
	
	框架都是半成品，因此Strut2也是半成品，我们使用Strut2来提高我们的项目的生产效率



2.开发人员用Struts2天天写什么？

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
	




3.Struts2的历史








 
4.搭建Struts2的开发环境

	1、拷贝jar包
	参考发行包中的struts2-blank.war中的jar
	 
	2、配置核心过滤器（控制器）
	 
	3、建立struts.xml的配置文件，放在应用的类路径的顶端（开发中：src目录下）
	 
	
	验证是否成功：部署到Tomcat中，启动，只要没有报错，就是OK。
	




	5.写struts配置文件没有提示的问题
	
		1、找到dtd，放到某一个目录中。WEB-INF/dtd
	
	



 
5.Struts2的执行流程全图（面试）
 
 
	Struts2的工作流程:
	一：客户端提交一个HttpServletRequest请求，（.action或JSP页面)
	二：请求被提交到一系列的Filter过滤器，如ActionContextCleanUp和FileterDispather等。
	三：FilterDispatcher是Struts2的控制核心，它通常是过滤器链中的最后一个过滤器。
	四：请求发到FilterDispathcher后，FilterDispatcher询问ActionMapper是否需要调用某个Action来处理这个Request（一般根据URL后缀是否为.action来判断）
	五：如果ActionMapper决定需要调用某个Action，FilterDispatcher则把请求交到ActionProxy,由其进行处理。
	六：ActionProxy通过ConfigurationManager（它会访问Struts.xml询问创建的配置文件，找到需要调用的Action类）
	七：ActionProxy创建一个ActionInvocation实例，而ActionInvocation通过代理模式调用Action（在调用之后会根据配置文件加载相关的所有Interceptor拦截器）
	八：Action执行完毕后，返回一个result字符串，此时再按相反的顺序通过Interceptor拦截器
	九：最后ActionInvocation负责根据struts.xml中配置的result，决定进行下一步输出


	简化版：
	①：客户端初始化一个指向Servlet容器的请求
	②：请求经过系列过滤器，FilterDispatcher被调用
	③：ActionMapper决定需要调用某个Action，FilterDispatcher把请求的处理交给ActionProxy
	④：ActionProxy通过ConfigurationManager询问框架的配置文件找到需要调用的Action类
	⑤：ActionProxy创建一个ActionInvocation实例
	⑥：ActionInvocation调用、回调Action的execute方法
	⑦：Action执行完毕ActionInvocation，根据struts.xml配置找到对应的返回结果





6.Struts2的配置文件和加载顺序

	1、default.properties 该文件保存在 struts2-core-2.3.7.jar 中 org.apache.struts2中
	2、struts-default.xml 该文件保存在 struts2-core-2.3.7.jar
	3、struts-plugin.xml 该文件保存在struts-Xxx-2.3.7.jar（struts2的插件jar包中）
	4、struts.xml 该文件是web应用默认的struts配置文件（程序员写）
	5、struts.properties 该文件是Struts的默认配置文件（程序员写）。构建路径的顶端
	6、web.xml应用的配置文件
	
	按照从1到6的顺序加载配置文件。后面的内容会覆盖前面的内容。
	1和2和3都在框架或插件提供的jar中，不需要我们直接改。









7.struts.xml配置文件的内容标签

	1、package：
	作用：分模块化开发。
	属性：
	name：包的名称。唯一。必须的
	extends：一般都需要直接或间接继承一个叫做struts-default（struts-default.xml中有定义）的包名。因为，struts框架的一些核心功能配置都在此处。
	abstract：如果为true，说明是一个抽象包。说明让别人去继承。没有任何action子元素的包就可以定义为抽象包。
	namespace：名称空间。一般以"/"开头，和动作名称一起，构成了用户的访问路径。
	比如：
	 
	
	专题：package中的namesapce属性
	2、action：
	作用：配置动作。用户什么请求，执行哪个类，及哪个类的方法。
	属性：
	name：动作名称。必须的。包中要唯一。
	class:动作类的全名。可以不指定，默认值是
	com.opensymphony.xwork2.ActionSupport
	 
	method：执行的动作类的动作方法。可以不指定，默认值是execute。
	 
	
	说明：可以覆盖掉默认的动作类。一般我们不需要这么做。
	 
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
	struts.serve.static.browserCache=true 静态资源告知浏览器不要缓存。
	Expires:-1;Cache-Control:no-cache;Pragma:no-cache
	4、包含其他的配置文件
	<include file="user.xml"></include>
	







8.动作类：Action

	1、编写动作类的方式
		方式一：动作类就是一个POJO。可以不用继承或实现任何的类或接口。
		方式二：动作类实现com.opensymphony.xwork2.Action接口。
	SUCCESS：一切正常时使用
	NONE：不转向任何视图时使用（文件下载时）
	ERROR：出错（异常中）
	INPUT：数据回显时。
	LOGIN：转向登录页面时。
		(推荐的)方式三：动作类继承ActionSupport类。
	2、动作方法：
	编写要求：
	必须是public的
	方法必须返回String的值。如果为null，则不转向任何的视图
	方法没有任何的参数
	3、动作方法的映射：
	 
	 
	4、DMI：Dynamic Method Invocation（动态方法调用）（了解）
	当前配置：没有指定动作方法
	 
	url：customer!addCustomer
	
	错误：
	 
	说明struts2框架默认是不允许执行动态方法调用的。如果要用，需要配置一个常量：
	 
	
	危险：容易把动作方法暴露给客户端
	5、默认的action






 

9.Servlet规范相关实例的获取

	1、Struts2的一大特点：与ServletAPI解耦了。
	2、获取Servlet有关的类
		方式一：（暂时记住。推荐的）
	 
		方式二：（麻烦。框架注入进来）
	 
	怎么做到的？实际上是一个拦截器来做的。
	<interceptor name="servletConfig" class="org.apache.struts2.interceptor.ServletConfigInterceptor"/>
	
	



 
10.Struts2中的结果视图

	1、展现结果
	通过struts.xml中result配置来管理的。
	2、result元素
	作用：配置一个结果视图
	属性：
	name：逻辑视图名称。对应的是动作方法的返回值。
	可以不写。默认值是success。
	type：指定结果类型。默认值是dispatcher,就是转发。
	
	问题：dispatcher从哪里来的？struts-default.xml中有定义。
	 
	3、常用的结果视图的类型
		dispatcher:默认结果类型。请求转发到一个页面。
		redirect：请求重定向到一个页面。
		chain:请求转发到另一个动作。
	 
		redirectAction：重定向到另外一个动作
		stream：下载用的（文件上传和下载时再议）
		plainText：以纯文本的形式展现内容
	