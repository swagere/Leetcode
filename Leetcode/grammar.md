### String

str.length()

str.charAt(i)



### int[]

num.length



### Math

Math.sqrt() ����ֵΪdouble



### List

#### 1. ��ʼ����

```java
List<String> stringList = Arrays.asList("a", "b", "c");
```



#### 2. ���÷���

List.contains()

List.indexOf()

List.sort()



#### 3. Listת��

int[]תList<Integer>

```java
integerArrayList = Arrays.asList(intArray);

//����
integerArrayList = Arrays.stream(intArray).boxed().collect(Collectors.toList()
```



List<Integer>תList<String>

```java
stringArrayList = integerArrayList.stream().map(String::valueOf).collect(Collectors.toList());
```

