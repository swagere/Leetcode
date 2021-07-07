### String

str.length()

str.charAt(i)



### int[]

num.length



### Math

Math.sqrt() 返回值为double



### List

#### 1. 初始化：

```java
List<String> stringList = Arrays.asList("a", "b", "c");
```



#### 2. 常用方法

List.contains()

List.indexOf()

List.sort()



#### 3. List转换

int[]转List<Integer>

```java
integerArrayList = Arrays.asList(intArray);

//或者
integerArrayList = Arrays.stream(intArray).boxed().collect(Collectors.toList()
```



List<Integer>转List<String>

```java
stringArrayList = integerArrayList.stream().map(String::valueOf).collect(Collectors.toList());
```

