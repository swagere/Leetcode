三大组件：

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