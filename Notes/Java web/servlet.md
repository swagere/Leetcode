**三大组件：**

- servlet
- filter
- listener



### 1. servlet介绍

- servlet是javaEE规范之一，规范就是**接口**
- 接收客户端发来的请求，并相应数据给客户端



### 2. servlet生命周期

- servlet构造器方法（实现类中的构造器方法
- init初始化
- service方法（可以多次访问
- destroy销毁（web工程停止时调用



### 3. 实现servlet程序

- 编写类 **实现**servlet接口

- 实现service方法，处理请求并响应数据

  - 分辨是哪种类型的请求
    - 通过ServletRequest的子类HttpServletRequest判断
  - 实现get/post具体的处理方法：doGet/doPost

- 在web.xml中配置servlet访问路径

  ```xml
  <!--声明一个servlet-->
  <servlet>
      <servlet-name>给servlet程序起一个别名，一般是类名</servlet-name>
      <servlet-class>servlet程序全类名（从src开始</servlet-class>
  </servlet>
  
  <!--给servlet程序配置访问地址-->
  <servlet-mapping>
      <servlet-name>告诉服务器当前配置的地址给哪个程序使用</servlet-name>
      <url-pattern>配置访问地址，如：/hello</url-pattern>
  </servlet-mapping>
  ```

  - 地址能访问到servlet原因：

    ![image-20210813110808435](C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210813110808435.png) 





### 4. 通过HttpServlet实现servlet程序

- 编写类 **继承**HttpServlet类
- 重写doGet与doPost方法
- web.xml中添加配置



### 5. servlet类的继承体系

#### 5.1 javax.servlet.Interface.Servlet

#### 5.2 javax.servlet.Class.GenericServlet

**实现类**

实现了有关ServletConfig的内容（一般用于初始化时获取信息



**ServletConfig**

- 作用：

  - 是GenericServlet的实例化成员变量
  - 即在web.xml中配置的，保存在ServletConfig对象中

- 实例化成员变量：
  - servletName：servlet别名

  - init-param：读取web.xml中设置的init-param初始化参数，键值对形式

    ```xml
    <!--web.xml<servlet>中设置的初始化参数-->
    <servlet>
        <init-param>
    		<param-name>username</param-name>
    		<param-value>root</param-value>
        </init-param>
    </servlet>
    ```

  - **servletContext**

    - 作用：

      - 一个接口，表示servlet上下文对象
      - 一个工程/模块只有一个servletContext实例，在工程启动时创建，工程停止时销毁
      - servletContext是一个域对象（即可以像map一样存取数据的对象，作用范围为整个实例

    - 实例化成员变量：

      - init-param：web.xml中配置的context-param上下文参数（属于整个web工程

        ```xml
        <!--web.xml中配置的上下文参数-->
        <context-param>
          	<param-name>name</param-name>
          	<param-value>hello</param-value>
        </context-param>
        ```

      - contextPath：当前工程路径，如/Java_Web

      - realPath：工程配置的绝对路径，即工程在tomcat配置文件里面部署的路径

        > 采用 web工程部署到tomcat服务器的第二种方式，映射到工程文件目录：即编译器拷贝工程，java文件被翻译为字节码文件

      - setAttribute/getAttrobute：实现像map一样存取数据

> 注：servletConfig对象在genericServlet的init(有参方法)中会被初始化，所以在继承时，如果重写了有参的init要先调用父类的init(有参方法)，或者直接重写无参的init()方法



#### 5.3 javax.servlet.http.Class.HttpServlet

 **继承类**

- 实现了service方法，实现了请求的分发处理，将对应请求分发到doGet/doPost方法中
  - doGet/doPost方法：只实现异常处理，即处理协议即版本的异常

