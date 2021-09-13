### 1. JUC

#### 1.1 JUC

java.util.concurrent

Java并发编程工具包



#### 1.2 进程和线程

##### 1.2.1 线程状态

- new 新建
- runnable 就绪
- blocked 阻塞
- waiting 不见不散
- timed_waiting 过时不候
- terminated 终结



##### 1.2.2 wait和sleep方法

- wait 
  - object类方法
  - 会释放锁
- sleep 
  - Thread类方法
  - 不占用锁 不释放锁



都可以被interrupted中断

从哪儿睡就从哪儿醒



##### 1.2.3 管程

即monitor 监视器

jvm同步使用管程对象实现



##### 1.2.4 用户线程和守护线程

- 用户线程：
  - 自定义线程
  - 主线程结束，有用户线程，jvm运行
- 守护线程：
  - 运行在后台的特殊线程，如垃圾回收
  - 主线程结束，没有用户线程，只有守护线程，jvm结束



### 2. Lock接口

#### 2.1 Synchronized关键字

**修饰范围：**

- 代码块：同步语句块
- 方法：同步方法
- 静态方法
- 类



#### 2.2 Lock接口

实现类：

- ReentrantLock可重入锁
  - lock()方法上锁
  - unlock()方法解锁，一般此方法写在finally代码块中（即使发生异常也会被调用，不会出现死锁现象



lock和synchronizedList对比

- synchronizedList是java关键字，自动实现锁
- lock是一个类，通过这个类手动实现锁



#### ~~2.3 创建线程的三种方式~~

- ~~继承Thread类~~
- ~~新建Thread类，实现Runable接口~~
- ~~使用Callable接口~~
- ~~使用线程池~~



### 3. 线程间通信

- synchronizedList
  - wait()方法
    - wait()中可能存在中断后虚假唤醒问题，故应该用while实现条件判断
  - notify()/notifyAll()方法
- lock
  - condition.await()方法
  - signal()/signalAll()方法



### 4. 线程间定制化通信

- 增加标志位并唤醒特定线程，确定线程间通信顺序



### 5. 集合的线程安全

ArrayList是线程不安全的

#### 5.1 ArrayList集合

##### 5.1.1 Vector类

层次：

- Object
  - AbstractCollection
    - AbstractList
      - Vector



add中添加了synchronizedList关键字



##### 5.1.2 Collections类

- Collections.synchronizedList(new ArrayList())方法，为新创的类加锁





##### 5.1.3 CopyOnWriteArrayList类

写时复制技术

- 读时支持并发读
- 写时要求独立写（用lock上锁）
  - 写的时候先将原数组复制一份，然后向复制后数组的写入
  - 写完之后和原数组合并



#### 5.2 HashSet集合

##### 5.2.1 CopyOnWriteArraySet类

同样使用写时复制技术



#### 5.3 HashMap集合

#####  5.3.1 ConcurrentHashMap类



### 6. 多线程锁

