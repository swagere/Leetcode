# 实习

## CVTE

### 1、在线笔试

- HTTP（PUT、GET、POST区别）
- TCP（三次握手）
- 排序（冒泡、插入、选择、快速、堆排序、归并、桶排序）
- 数据结构（树的遍历，前中后序）
- 设计模式（创建者模式、结构型模式、行为模式）
- Java基础（接口、继承类）
- Java集合（HashMap、HashSet、LinkedList、ArrayList）
- JVM（类加载器、双亲委派机制）
- 数据库（索引）
- Spring（@Transaction注解在什么异常下会回滚事务）
- 两道算法题
  - 数列问题，a~1~ = 8，a~n~ = a~n-1~ + n，求 a~n~ = ?
  - 台阶问题，一次可以跳1、2、3个台阶，对于N个台阶，有几种跳法？
- 一道主观题：用户通过A系统，存入商品参数信息，下游系统有B、C、D等系统，应该采用什么同步机制，使得下游系统近实时获取某个商品的参数信息？

### 2、电话一面

- 最满意的项目？最大的难点？怎么解决？
- MySQL索引【索引覆盖、回表、下推、存储结构etc】
- 慢SQL怎么优化 —> Explain —> Type Extra字段 —> 实际应用场景？
- Spring 中 filter 和 interceptor ？SpringBoot 自动配置？
- JVM内存结构、回收算法
- HTTP请求方法、HEAD和GET的区别？HTTP中的字段？
- HTTP各版本特点和改进？
- 给定排序数组和一个数值，求任意两数之和为给定数值的下标？
- 给定一个乱序数组，里面有1000个数，数值都处于1~100，求没有在这个范围内出现的数字？

## 同程旅行（大数据相关）

### 1、电话一面

- 大数据了解嘛？Hadoop、Hive等（回答了一下MapReduce，大数据特点5V）

- String a = new String(“abc”); 生成了几个对象？

- 线程池（ExecutorService四种默认实现、ThreadPoolExecutor七大参数）

  假如A、B、C同时提交1000个执行任务到同一个线程池里，如何保证A的任务先执行，而后是B、C ？

- 线程状态（sleep不释放锁，但释放CPU资源）sleep(0)的用法？

- HashMap源码（各种操作、红黑树和链表的转换条件）

- 锁类别、升级（无锁、偏向、自旋锁、重量级）

- GC算法（3种 + 分代收集算法）==》新生代、老年代、方法区（JDK8前后不同的实现）[如何定位垃圾（两种）]

- 4种引用（强软弱虚）[ThreadLocal]

- MySQL事务隔离级别（4种）[脏读、可重复读、幻读]

- 一个select很复杂，30分钟都还没有结束，这个现象有没有产生锁？（MySQL锁级别）

- 搭虚拟机？Linux中有一个进程CPU 100% 时间久，排查思路？（ps -ef | grep XX ？）

## 腾讯

### 1、视频一面

- 字符串分割，手写简单split()函数
- char/varchar/text的区别

- TCP四次挥手，TIME_WAIT为什么是2MSL？（TIME_WAIT 和 CLOSED_WAIT 的区别？）

  过多TIME_WAIT 导致端口占用，Linux如何解决？

  长连接有啥问题？—> HTTP/1.0/1.1/2/3区别！

- 两个修改请求同时到达服务端，如何处理？

- MySQL主从复制！！？？binlog，起始同步位置……

- SQL注入及其解决方案~

- 用户密码加密，Spring Security加密算法、过程、原理！

## 阿里巴巴（数据研发）

### 1、电话面

- Spring AOP和IOC？AOP具体实现原理？
- MySQL事务的ACID？MVCC？Next-Key Locks？
- Druid连接池，其他连接池区别？
- ConcurrentHashMap怎么做到并发执行？
- Java并发基础……

## 字节跳动

### 1、视频一面

- 项目介绍
- 写个冒泡排序？

### 2、视频二面

- Full GC如何解决？
- 悲观锁和乐观锁 —> 分布式锁？
- GET和POST请求的区别？
- 301和302的区别？
- 索引过多会有什么问题？
- Druid连接池和其他连接池有啥区别？

## 腾讯微保

### 1、视频一面

- 项目介绍、RBAC的理解、权限复杂了性能问题怎么解决？
- Java内存分配和回收机制
- AOP原理
- 谈谈Spring Cloud的理解
- 长链接(URL)转短链接，实现原理？

## WeBank

### 1、视频一面

- 博客系统一些了解~
- syschronized修饰代码块、静态方法、普通方法的区别
- 三个线程执行a++一百次，volatile与synchronized修饰，结果有什么不一样？
- 主线程等待三个线程执行完后再进行输出？CountDownLatch，定义一个变量，join；
- 线程池7大参数，4个常见方法的缺陷
- Spring Boot默认的日志组件？SL4j和Logback、Log4j、Log4j2的区别？
- jar包有多少？Maven？IDEA自带生成依赖关系图
- Spring Bean生命周期和作用域，创建Bean的具体流程？线程安全怎么理解？Bean是否线程安全？
- 在Bean创建时和销毁时做一些处理？
- 自定义类加载器？
- 组合索引，where不同条件走不走索引？
- Explain字段？
- JDBC操作的具体步骤？
- Spring事务？事务传播？
- MySQL事务隔离级别？
- MySQL分批update的理由？