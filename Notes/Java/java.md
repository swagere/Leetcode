## Java SE

### 语言基础

byte区间：-128~127

byte + int 类型自动提升 会产生溢出



### 面向对象



#### 封装

#### 继承

#### 多态

多态与接口回调



#### 抽象

#### 接口

内容：常量、抽象方法



支持实例方法

```java
public interface MyInterface {
	default void hello() {
        
	}
}
```



#### 重写

有继承关系才能重写

关键词：extends



派生类的访问权限不能低于父类的权限

只能继承非私有的方法/变量

子类的异常不能比父类的更抽象



- final
  - 修饰类
  - 修饰方法
    - 不能再被重写
  - 修饰变量
    - 成员变量
      - 必须显示初始化（如：`final String str = "111"`）/在构造方法初始化
    - 局部变量
      - 其基本类型为引用类型
      - 引用不能变（如引用的为一个类，则是引用的类不变，而不是引用的类的值不变）
- static
- super：调用父类方法
- extends
- object：所有类的父类
  - toString
  - equals
  - hashCode
  - getclass



### 异常

所有异常的父类：Throwable





### 集合框架

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210607155119422.png" alt="image-20210607155119422" style="zoom: 50%;" /> 

#### List

> arraylist vector的区别（底层都为list）



##### ArrayList

底层为数组

查询快，增删慢



**源码：**

1. 构造方法：（创建list时）list长度为空 

2. add扩容机制：

   <img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210607201508173.png" alt="image-20210607201508173" style="zoom: 67%;" /> 

   - 第一次添加：长度为10

   - 其他添加：（长度不够时才添加）

     - 其长度为原长度的1.5倍

     - 直接等于新长度

     - 直接等于最大容量（数组长度大于`int最大值-8`时）

       - 异常处理

         > 因为容量是以int类型的变量，即minCapacity，若minCapacity小于0，则抛出异常

       - 容量处理



##### LinkedList

底层基于链表（双向链表）

查询慢



**源码：**

1. add扩容机制：

    <img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210607210600848.png" alt="image-20210607210600848" style="zoom:67%;" /> 

   直接挂到尾节点上

   - 链接到尾节点位置
   - 判断是否链表是否为空

2. remove方法
   - 不链接
     - 判断是否为头
     - 判断是否为尾
   - 判断是否为空





##### Vector

基于数组



**源码：**

1. 初始化：初始容量为10，容量增量为0

2. add扩容机制：

   <img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210607211500666.png" alt="image-20210607211500666" style="zoom:67%;" /> 

   类似于arraylist，但是多了modCount（保证线程安全）

   - 其长度为原来的2倍
   - 长度+需要扩容的长度

   



#### Map

##### 迭代器：

- 将key value分为两列，根据key拿到value

  - for each

    ```java
    Set<Integer> keys = map.keySet();
    for (Integer i : keys) {
        System.out.println(map.get(i));
    }
    ```

  - iterator迭代器

    ```java
    Set<Integer> keys = map.keySet();
    Iterator<Integer> iterator = keys.iterator(); //拿到迭代器
    while (iterator.hasNext()) { // 有没有下一个数据
        Integer next = iterator.next();
        System.out.println(map.get(next));
    }
    ```

- 将key value包装成一组进行迭代

  ```java
  Set<Map.Entry<Integer, String>> entries = map.entrySet();
  Iterator<Map.Entry<Integer, String>> iterator = entries.iterator(); //拿到迭代器
  while (iterator.hasNext()) {
      Map.Entry<Integer, String> next = iterator.next();
      System.out.println(next.getValue());
  }
  ```

  

##### HashMap

map底层为数组 链表 红黑二叉树



**源码：**

put：

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609141755711.png" alt="image-20210609141755711" style="zoom: 67%;" /> 

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609143244406.png" alt="image-20210609143244406" style="zoom:67%;" /> 

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609145031737.png" alt="image-20210609145031737" style="zoom:67%;" /> 

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609145945403.png" alt="image-20210609145945403" style="zoom:67%;" /> 

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609150120891.png" alt="image-20210609150120891" style="zoom:67%;" /> 



**图示原理：**

以key值做hash，hash值即为数组中该放置的位置

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609143928647.png" alt="image-20210609143928647" style="zoom:67%;" /> 

如果找到一样的hash值，且key值一样，就直接覆盖

如果找到一样的hash值，且key值不一样，就链出一个链表

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609144248875.png" alt="image-20210609144248875" style="zoom: 50%;" /> 

当链表中数据量超过8时，则将链表转换成红黑树

当删除节点，剩下的节点小于6时，则红黑树又转换为链表

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609144631086.png" alt="image-20210609144631086" style="zoom:50%;" /> 



##### HashTable

线程安全

key value均不能为空

底层实现为数组 链表



##### TreeMap

能存入则必须具备被比较功能，支持自然排序和定制排序功能



#### Set

无序（不能保证插入顺序）且不重复的list



**源码：**

add添加：

底层用map.put实现



##### TreeSet

能存入则必须具备被比较功能，支持自然排序和定制排序功能

如Integer等具有自然排序功能



（必须要有被比较的功能才能放进TreeSet中）

定义外部比较器进行排序：

```java
public class MyCom implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
```





**源码：**

put实现：

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609152556752.png" alt="image-20210609152556752" style="zoom:67%;" /> 



### 多线程

### IO

### 网络编程



### 新特性

#### lambda

**条件：**

- 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法。

  无论是JDK内置的 Runnable 、 Comparator 接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。

  如注解@FunctionInterface，定义内部只有一个抽象方法

- 使用Lambda必须具有上下文推断。

  即lambda实现这个抽象方法

  也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。



lambda本质为一个接口的实例对象，专门用于传参



**语法：**

(参数1,参数2)->{方法体}

```java
Set<Person> people = new TreeSet<>((Person o1, Person o2)->{return o1.getAge()-o2.getAge();});
```



省略规则：

- 小括号内参数的类型可以省略；
- 如果小括号内有且仅有一个参，则小括号可以省略；
- 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。

```java
Set<Person> people = new TreeSet<>((o1, o2)->o1.getAge()-o2.getAge());
```



#### 函数式接口

##### 定义：

有且仅有一个抽象方法的接口

- 注解@FunctionInterface，定义内部只有一个抽象方法
- 不使用注解，但是也只有一个抽象方法



##### 常用函数式接口：

###### supplied

用来返回一个值



**源码：**

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609165435698.png" alt="image-20210609165435698" style="zoom:67%;" /> 

 

**实例：**

```java
public static void main(String[] args) {
//        hh(new Supplier<String>() {
////            @Override
////            public String get() {
////                return UUID.randomUUID().toString();
////            }
////        });
        hh(()->UUID.randomUUID().toString());
    }

    public static void hh(Supplier<String> supplier) {
        String s = supplier.get();
        System.out.println(s);
    }
}
```



###### consumer

不是生成一个数据，而是消费一个数据

 

**源码：**

<img src="C:\Users\12505\AppData\Roaming\Typora\typora-user-images\image-20210609170943929.png" alt="image-20210609170943929" style="zoom: 67%;" /> 

 

**实例：**

```java
public static void main(String[] args) {
//        hh2(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        },100);
        hh2(integer -> System.out.println(integer), 100);
    }

    public static void hh2(Consumer<Integer> consumer, Integer integer) {
        consumer.accept(integer);
    }
}
```



###### Function接口

两个泛型的接口，根据一个类型的数据，得到另一个类型的数据

 

**实例：**

```java
public static void main(String[] args) {
        hh3(a->a.length()+2,"badasdasdas");
    }

    public static void hh3(Function<String, Integer> function, String s) {
        Integer apply = function.apply(s);
        System.out.println(apply);
    }
}
```



###### Predicate

对某种类型的数据进行判断，从而得到一个boolean结果

 

实例：

```java
public static void main(String[] args) {
        hh4(a->a.length()>10, "sdfafsdscad");
    }

    public static void hh4(Predicate<String> predicate, String s) {
        boolean pre = predicate.test(s);
        System.out.println(pre);
    }
}
```



#### Stream

##### 流式思想

lambda有延迟执行特性，必须有终止函数count时，整个流程才会被执行

本身不存储任何元素



##### 流操作

获取流：

.stream()单列集合获取流

```java
list.stream() #list
map.keySet().stream() #map
map.valueSet().stream()
map.entrySet().stream()
Stream.of(array) #array
```



常用方法

- forEach(Consumer) 逐一处理【终结方法】
- count() 统计流里面的个数【终结方法】
- filter(Predicate) 过滤，通过filter将一个流转换成另一个子集流
- limit() 取前几个
- skip() 跳过前几个
- map(Function) 映射将流中的T类型转换为R类型
- concat() 组合 
- collect(Collectors.toList()) 收集stream的结果



实例：

```java
list.stream().filter(x->x.length()==3).filter(x->x.startsWith("张")).forEach(System.out::println);
```



### JVM
