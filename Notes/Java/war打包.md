### 1. jar和war区别

- jar
  - 内置web容器
- war
  - 需要基于外部容器运行



### 2. dependencyManagement与dependencies区别

- dependencyManagement

  - 用于管理jar包版本，其子项目中不用显示出依赖的版本号
  - 只是声明依赖，并不实现引入
  - 子项目没有，则不继承父项目的该依赖

  > 只有父子项目中有该依赖，且没有指定具体版本，才会从父项目中继承该项，并且version和scope都读取自父pom

- dependencies

  - 直接将依赖引用到项目
  - 子项目会继承父项目中的全部



### 3. 打包步骤

1. 修改pom.xml文件

   ```xml
   <!--修改打包方式为war方式-->
   <packaging>war</packaging>
   
   <!--修改加载方式为provided，表示只在编译运行、测试阶段起作用，在打包时不打包该模块-->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-tomcat</artifactId>
       <scope>provided</scope>
   </dependency>
   
   
   ```

   > spring-boot-starter-web包中包含spring-boot-starter-tomcat包

2. 修改启动类，继承SpringBootServletInitializer类，并且重写configure方法

   ```java
    @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
       return builder.sources(this.getClass());
   }
   ```

3. 在idea中的maven-项目-lifecycle-package中打包即可在target中得到war包



### 4. 容器运行

将idea中的tomcat读取war包的目录改在工程文件生产war包的目录

再启动tomcat容器即可

https://www.cnblogs.com/Knowledge-has-no-limit/p/7240585.html



### 5. 本地调试

idea中配置tomcat方式

相当于运行本地tomcat文件，即运行startup文件，只是可视化到了idea中



##### 5.1 idea中下载tomcat插件

setting-plugin-搜索tomcat，下载smart tomcat插件



##### 5.2 idea中配置tomcat服务

edit Configurations-tomcat-配置，修改启动路径



### 6. idea远程调试测试环境中的war包

