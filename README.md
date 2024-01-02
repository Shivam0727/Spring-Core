What is Spring Framework :
---------------------------------------------------------------------------------------------------------------------------------------------------------- 
--> Spring is a dependency injection framework to make java application loosely coupled.
--> Spring framework makes the easy development of JavaEE application.
--> It was developed by Rod Johnson in 2003.


Dependency Injection :
----------------------------------------------------------------------------------------------------------------------------------------------------------
--> It is design pattern.

class Ramu					 |--------->class Geeta
{							 |			{
	Geeta ob;----------------|				public void doWork()
	public void doWork() 					{
	{
	
	}										}
}										}

- Ramu class need Geeta class object to do work. Initially for do such a task we create objects using new keyword.
But using new keyword makes java program highly coupled. In such scenario where a class is depend on another class
and we want to use object of one class into another class then we use Dependency Injection.
In this scenario Geeta object is created and injected in Ramu class automatically.
   
- This whole process is known as Inversion of control (IOC Container).

IOC Container : 
----------------------------------------------------------------------------------------------------------------------------------------------------------
When we created object, the control of object creation is taken from developer hands to spring, for
every dependency spring create a object dynamically at runtime.

Spring and JEE Layer :
---------------------------------------------------------------------------------------------------------------------------------------------------------- 
	
	UI Layer				Example :	ProductController <---|
		|										|			  |	Inject			
		V										V			  |
	Business/Service Layer					ProuctService-----|
		|										|		  <---|
		V										V			  |	Inject
	Data Access Layer						ProductDao--------|
		|							------------|
		V							|
	Database <----------------------|

Spring Modules :
----------------------------------------------------------------------------------------------------------------------------------------------------------

	 				
_____________________________________________________________
|-> Data Access/Integration:|->	Web :						|
|	JDBC		ORM			|	Web			Servlet			|
|	JMS			OXM			|	Portlet		WebSocket		|
|-----------------------------------------------------------|
|	AOP		Aspect			Instrumentation		Messaging	|
|-----------------------------------------------------------|
|					Test									|
|-----------------------------------------------------------|
|->	Spring Core :											|
|	Core		Beans			Context		spEL			|
|___________________________________________________________|
				

Spring IOC Container : 
----------------------------------------------------------------------------------------------------------------------------------------------------------
It does 3 work : 
		-> Create the object.
		-> Hold them in a memory.
		-> Inject then in another object as required. 

Spring container : 
					-> Interface ApplicationContext ( Extends Bean Factory )
								--------------------
										|
				--------------------------------------------------
 				|						|						 |
  				|						|						 |
				V						|						 V
AnnotationConfigApplicationContext		|		ClassPathXMLApplicationContext
										|
										V
						FileSystemXMLApplicationContext


Ways of Dependency Injection :
-------------------------------------------------------------------------------------------------------------------------------------------------------
	
	1- using setter injection
	2- using constructor injection

Setter Injection :

class Student 						class Address
{									{
	id,name,address						street,city,state,country <--|
	^	^	  ^							^		^     ^				 |
	|	| 	  |-----------|				|		|	  |-------|		 |
	|	------------|     |				|       -----------|  |      |
	setId(id){}		|	  |				setStreet(street)  |  |		 |
	setName(name){}-|	  |				setCity(city)------|  |		 |
	setAddress(address){}-|				setState(state)-------|		 |
}										setCountry(country)----------|
									}
			- Ioc container create object of address using setter methods during configuration.
									
									
Contructor Injection :

class Student 						class Address
{									{
	id,name,address						street,city,state,country <--|
	^	^		^							^	^	  ^				 |
	|	|		|--------|					|	|	  |-------|		 |
	|	|				 |					|	|-------|	  |		 |
	|	|--------|		 |					|-----|		|	  |		 |
	|--------|	 |		 |						  |		|	  |		 |
	Student(id,name,address)			Address(street,city,state,country)
	{									{
	
	}									}
}									}

			- Ioc container create object of address using constructor methods during configuration.


Configuration File :
--------------------------------------------------------------------------------------------------------------------------------------------------------
- Spring contain configuration file i.e; XML file.
- The class which is provided to IOC Container is known as Beans.
- Configuration file where we declare beans and its dependency.

	<beans>
		<bean>...</bean>
		<bean>...</bean>
	</beans>

Data Types (Dependencies) :
---------------------------------------------------------------------------------------------------------------------------------------------------------

1- Primitive Data Types :
	byte,short,char,int,float,double,long,boolean

2- Collection Type :
	list,set,map and properties

3- Reference Type :
	Other class object
	Ex : previously we inject object of class Address in class Student.
	
	
Steps :	
---------------------------------------------------------------------------------------------------------------------------------------------------------
-Create a Maven Project
- Add dependency inside pom.xml file :
		1- Spring core : stable version
		2- Spring context : same version as spring core
- Creating bean : Java pojo
- Creating configuration file -> config.xml
- Main class : which can pull the object		

Insertion Of Primitive Type :
---------------------------------------------------------------------------------------------------------------------------------------------------------

Note : Inside config.xml file add this name-space :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:context="http://www.springframework.org/schema/context"
 xmlns:p="http://www.springframework.org/schema/p"
 xsi:schemaLocation="http://www.springframework.org/schema/beans
 http://www.springframework.org/schema/beans/spring-beans.xsd
 http://www.springframework.org/schema/context
 http://www.springframework.org/schema/context/spring-context.xsd">

</beans>

- Inside Beans tag we create a bean :

<!-- This is our bean -->

<bean class="com.spring.Student" name="student1">
<property name="studentId">
<value>101</value>
</property>
<property name="studentName">
<value>Shivam Barekar</value>
</property>
<property name="studentAddress">
<value>Pune</value>
</property>
</bean>

- If we want to use value as a attribute then we have a specific way to do so :
	<property name="studentId" value="102" />

- If we want to set value using p-schema then we have a specific way to do so :
	<bean class="com.spring.Student" name="student3" p:studentId="103" p:studentName="Shiv" p:studentAddress="Nagpur" />

Insertion Of Collection Type : 
---------------------------------------------------------------------------------------------------------------------------------------------------------

List : 
		
		<bean>
			<property name="">
				<list>
					<value>10</value>
					<value>100</value>
					<value>1000</value>
					<value>10000</value>
				</list>
			</property>
		</bean>	
			
Set : 
		
		<bean>
			<property name="">
				<set>
					<value>10</value>
					<value>100</value>
					<value>1000</value>
					<value>10000</value>
				</set>
			</property>
		</bean>		
		
Map : 
		
		<bean>
			<property name="">
				<map>
					<entry key="java" value="2 Months" />
					<entry key="python" value="1 Months" />
				</map>
			</property>
		</bean>		
		
Properties : 
		
		<bean>
			<property name="">
				<props>
					<prop key="java">2 Months</prop>
					<prop key="python">1 Months</prop>
				</props>
			</property>
		</bean>		
				

Example : let say in the bean class with name as Employee having this fields :
			private String name;
			private List<String> phones;
			private Set<String> addresses;
			private Map<String, String> courses;
	
	Write a code inside a config.xml file : 
					
	<bean class="path of bean class" name="give any name for this class" >
	<property name="name" value="Shivam" />
	<property name="phones">
	<list>
		<value>7038229942</value>
		<value>9511734369</value>
		<value>7979992384</value>
		<null />
	</list>
	</property>
	<property name="addresses">
	<set>
		<value>Pune</value>
		<value>Nagpur</value>
		<value>Kuchana Complex</value>
	</set>
	</property>
	<property name="courses">
	<map>
		<entry key="Java" value="2 Months" />
		<entry key="Python" value="1.5 Months" />
		<entry key="SQL" value="1 Months" />
	</map>
	</property>
</bean>


Injection Of Reference Type :
------------------------------------------------------------------------------------------------------------------------------------------------
	A --> Depends on B
	^				 |
	|----------------|
		Reference
	
	<bean>
		<property name="a">
			<ref bean="">
		</property>
	</bean>	

Example : Let say we have two class i.e; A and B.
	Class A have field : 
				private int x ;
				private B obj;
	Class B have field :
				private int y ;
				
 Write a code inside config.xml file : 
 
   <!-- Insertion Of Reference Type : -->
	<bean class="com.springcore.reference.B" name="bref" >
		<property name="y" value="90" />
	</bean>

	<bean class="com.springcore.reference.A" name="aref">
		<property name="x" value="60" />
		<property name="obj">
			<ref bean="bref"/>
		</property>
			<property name="obj" ref="bref"></property> --> Another way to declare a ref ...
	</bean>							

Constructor Injection : 
----------------------------------------------------------------------------------------------------------------------------------------------
Spring supports creating objects using parameterized.

	<constructor-args>
		<value>b</value>
	</constructor-args>

	<constructor-args>
		<ref bean="" />
	</constructor-args>

	As a attribute :
	<constructor-args value="" />

	To avoid ambuguity we need to add parameter as type .
	For ex : <constructor-args value="" type="int/String/float etc" />
	
	Bydefault everytime bean searches for string argument constructor but if it is not present then it follows top to bottom search.	
	
	In the given below code if we remove string arg constructor then double arg constructor will call,
	because it comes first during searching but if string arg constructor is present inside the code ,
	then that constructor is call always irrespective to the sequence.
	
	public Addition(double a, double b) {
		super();
		this.a = (int)a;
		this.b = (int)b;
		System.out.println("Constructor : double , double");
	}
	public Addition(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("Constructor : String , String");
	}
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Constructor : int , int");
	}
	
	To avoid this ambiguity we use Type parameter during constructor-args.


Life Cycle Methods :
-----------------------------------------------------------------------------------------------------------------------------------

Spring provide two important methods to every bean :

	public void init()	--> Initialization code Loading config, Connecting db, Webservice etc.
	public void destroy() --> Clean up code.
	
	Note : we can change the name of these method but signature must be same.

				----------------------------------------------------------------------
	Spring		|			Start													  |
				|													  				  |
	Bean		|				Init()												  |
				|																	  |
Configuration	|				Then we read and use the bean						  |
	XML			|																	  |
				|				Destroy()											  |
				|																	  |
				|			End														  |
				|																	  |
				|																	  |
				|																	  |
				|_____________________________________________________________________|


Configure Technique :

					1-XML
					2-Spring Interface
					3-Annotation



Implementing Lifecycle Method Of Spring Bean Using XML :
-------------------------------------------------------------------------------------------------------------------------------------

Inside config file :

	<bean class="com.springcore.lifecycle.Samosa" name="s1" init-method="init" destroy-method="destroy">

In the bean class : 
	
	We need to create two additional methods for init and destroy : 
	
	public void init() {
		System.out.println("Inside Init Method...");
	}
	
	public void destroy() {
		System.out.println("Inside Destroy Method...");
	}	
	
	Note : But there is one issue , the destroy method will not called because we need to enable SpringShutdownHook on context.
		
		For enabling this shutdownhook we need to replace the ApplicationContext to AbstractApplicationContext .
		
			AbstractApplicationContext --> Method : context.registerShutdownHook()


Implementing Lifecycle Method Of Spring Bean Using Interfaces :
-------------------------------------------------------------------------------------------------------------------------------------
Interface :

	1- Initializing Bean --> for init
	2- Disposable Bean --> for destroy


	Inside Bean class Implement this two methods by implementing class : 
	
	class Pepsi implements InitialisingBean,DisposableBean {
	
		public void destroy() throws Exception {
			System.out.println("Inside Disposable Bean : Destroy");			
		}

		public void afterPropertiesSet() throws Exception {
			System.out.println("Inside Initializing Bean : Init");		
		}
	}


Implementing Lifecycle Method Of Spring Bean Using Annotation :
-------------------------------------------------------------------------------------------------------------------------------------
Annotation :

	--> @PostConstruct : Init Works
	--> @PreDestroy : Destroy Works

First add a dependency inside pom.xml file for postconstruct and predestroy as it is depreciated after java 9 so we need dependency 
to use both annotation :

<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>

Create a bean and create two methods inside that bean :
	
	
	@PostConstruct
	public void start() {
		System.out.println("Starting Method : Init");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Ending Method : Destroy");
	}

Still the output will not desplay on console because we need to enable the annotation .
To do so we need to go to config.xml and write this :

 <context-annotation-config />


Autowiring in Spring :
---------------------------------------------------------------------------------------------------------------------------------------

- Feature of spring framework in which spring container inject the dependencies automatically.
- Autowiring cant be used to inject primitive and string values. It works with reference only.


		A class --> B class				Manually :					Automatically :
		   ^			|				<ref bean="" />					|
		   |			|												V
		   |			|											Spring container
		   |------------|				Programmer	
				Obj

	Autowiring :
				1- Using XML : no , byName , byType , constructor , autoDetect--> It is depreciated since spring 3.
				2- Using Annotations : 	@Autowired						

	Advantages :
				1- Automatic
				2- Less Code

	Disadvantage : 
				1- No control of programmer
				2- It cant be used for primitive and string value


Example : 


<bean class="com.springcore.autowired.Address" name="address">
	<property name="street" value="Marine Lines" />
	<property name="city" value="Mumbai" />
</bean>

byName :
<bean class="com.springcore.autowired.Employee" name="employee" autowire="byName" />
byType :
<bean class="com.springcore.autowired.Employee" name="employee" autowire="byType" />	
Constructor :
<bean class="com.springcore.autowired.Employee" name="employee" autowire="constructor" />	

Note : If two bean having same type then it throws an exception.


Using Annotations :

Inside bean class just add annotation : @Autowired
		-> @Autowired is add above field object name ( private Address address ) or above getter method or above constructor.
And inside config file : <context:annotations-config />

If more than one bean is there then it throws an exception . So to avoid that we need to use @Qualifier annotation :
	@Qualifier("address1")
					|-----> Bean name.
Qualifier annotation is applied just below the Autowired annotation.					


Standalone Collections : 
--------------------------------------------------------------------------------------------------------------------------------------------
1- Create a pojo class having fields of collection type :
	private List<String> friends ;
	private Map<String , Integer> feestructure ;
	private Properties properties ;

2- Inside config file first add util schema inside xmins :
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/util
    http://www.springframework.org/schema/util/spring-util.xsd
    ">
		
3- Now to create standalone collection we need to write code like this :
	<!--  Standalone List -->
	<util:list list-class="java.util.LinkedList" id="mybestfriends">
		<value>Priyanka</value>
		<value>Shiv</value>
		<value>Ankit</value>
		<value>Archana</value>
		<value>MC-Stan</value>
	</util:list>
	
	<!--  Standalone Map -->
	<util:map map-class="java.util.HashMap" id="fees">
		<entry key="Spring Framework" value="8000" />
		<entry key="Django Framework" value="5000" />
		<entry key="Hibernate Framework" value="2000" />
	</util:map>
	
	<!--  Standalone Properties -->
	<util:properties id="dbconfig">
		<prop key="driver">com.mysql.cj.jdbc.Driver</prop>
		<prop key="username">root</prop>
		<prop key="password">Shivam@07122000</prop>
		<prop key="url">mysql:jdbc://localhost:3306/youtube</prop>
	</util:properties>
	
	<bean class="com.SpringCore.standalone.collection.Person" name="person1">
	<!-- 	
	<property name="friends">
			<ref bean="mybestfriends" />
		</property> 
		-->
		
		<property name="friends" ref="mybestfriends" />
		<property name="feestructure" ref="fees" />
		<property name="properties" ref="dbconfig" />
	</bean>
	

Stereotype :
--------------------------------------------------------------------------------------------------------------------------------------------------
We use stereotype to eliminate the bean configuration and instead of that we use @Component annotation
to configure bean class.

In the config file we need to add one tag :
	<context:component-scan base-package="com.springcore.stereotype" />
													|------> package name ...
													
Inside the bean class :

	//@Component("obj") --> for change the object reference from student to obj ...
	@Component
public class Student {
	@Value("Shivam Barekar")
	private String studentName ;
	@Value("Kuchana Complex")
	private String city ;								
}

Inside Test class we need to add the object name as camel case in the location which is given below :
		Student student = (Student) con.getBean("student");
													|-------------> This is object of class Student which follows camel case.
															
How to use collection with this concept ? 

//@Component("obj") --> for change the object reference from student to obj ...
@Component
//@Scope("prototype") --> using this annotation we get prototype so by every object we get difference hash-code ...
public class Student {
	@Value("Shivam Barekar")
	private String studentName ;
	@Value("Kuchana Complex")
	private String city ;
	@Value("#{temp}")
	private List<String> address ;
}

Create a standalone list inside config file .

	<util:list list-class="java.util.ArrayList" id="temp" >
  		<value>Nagpur</value>
  		<value>Pune</value>
  		<value>Chandrapur</value>
  	</util:list>

Bean Score : 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	1- Singleton : only single object is created by spring container.
	2- Prototype : Every time new object is created whenever it is called.
	3- Request
	4- Session
	5- Globalsession

- Bydefault singleton scope is applied to spring.

Singleton Scope : 
	
	let say inside Test class we call same object twice :
		Student student1 = con.getBean("student",Student.Class);
		Sysout(student1.hashCode());
		Student student2 = con.getBean("student",Student.Class);
		Sysout(student2.hashCode());

		|-----> Same hashcode will be display by both the object.
		

Configure Bean Scope :
 
	1- XML file :

	<bean class="" name="" scope="" />
	
	2- Annotation :

	@Component
	@Scope("")
	Class Student {
	
	}
	
	Let say we create a bean class and add annotation @Scope("prototype")
	And inside Test class :
	Student student1 = con.getBean("student",Student.Class);
		Sysout(student1.hashCode());
		Student student2 = con.getBean("student",Student.Class);
		Sysout(student2.hashCode());

			|-------> Both objects gives different hashcode.



Spring Expression Language :
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	- Supports parsing and executing expression with the help of @Value annotations.
											@Value("#{2+3}")
		Expression							@Value("#{T(java.lang.Math).sqrt(625)")
			|								@Value("#{Expression}")
			|
			V
	Classes ,Variable , Methods , Constructors , Objects & Symbols .
	char , numerics , operators , keywords and special symbols which return a value.

Ex : 
	@Value("#{11+22}")
		|-----------------> output : 33
	
	@Value("#{8>6?88:55}")
		|-----------------> output : 88
		
	We can also call static methods , object methods or variables.
	
		
How to invoke static method and variable ? 

	--> 	T(class).method( parameter )		
		
		Ex : T(java.lang.Math).sqrt(625);
		
	--> 	T(class).variable	
		
		Ex : @Value("#{T(java.lang.Math).E}")
			
How to create Objects ?
		
		new Object(value)
		
		Ex : @Value("#{new java.lang.String('Shivam Raju Barekar')}")
		
How to create Boolean Value ?

			@Value("#{8>3}")
			private boolean isActive ;
								|-----------> True ...







































































































































































































