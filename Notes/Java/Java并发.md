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

当有多个方法都加上了锁时



#### 6.1 synchronized作用范围

当有多个方法都加上了synchronized锁时：

- 当用在实例方法上时，synchronized锁住的是当前对象
- 当用在静态方法上时，synchronized锁住的是当前类Class（字节码)
  - 此时只要是这个类的对象，无论是否为同一对象都会同步阻塞
- 当用在方法块上时，synchronized锁住的是括号内的对象/类



#### 6.2 公平锁和非公平锁

ReentrantLock通过队列可实现

- 非公平锁NonFairSync：
  - 实现：发现没人抢占锁时，直接尝试获取锁，不去检查队列
  - 可能造成线程被饿死的情况
  - 执行效率高
- 公平锁FairSync：
  - 实现：发现没人抢占锁时，先判断队列中是否有等待的节点，如果有的话就排队，如果没有的话就尝试获取锁
  - 不会有线程被饿死的情况
  - 效率相对较低



#### 6.3 可重入锁

可重入锁也可叫做递归锁



synchronized和lock都是可重入锁

- synchronized隐式可重入锁
  - 隐式：即上锁解锁自动完成
  - 可重入锁：当多层锁都为同一个锁时，拿到最外层的锁，就可以自由进入内层锁的区域而不会因为所被占用而被阻塞
- lock显示可重入锁：手动上锁解锁



#### 6.4 死锁

- 死锁：两个或两个以上的进程，在执行过程中因为资源抢夺而造成互相等待的现象即死锁
- 验证死锁：
  - jps：查看当前运行的进程
  - jstack + 进程号：跟踪堆栈信息，jvm中自带堆栈跟踪工具









