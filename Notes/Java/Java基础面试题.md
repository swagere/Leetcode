### 数据类型+运算符

#### 赋值

整型的字面值为int型，在赋值语句中类型为byte、short、char时 在范围内 由编译器自动加上强制类型转换



#### 运算

> byte, short, char混合运算的时候，各自先转换成int类型再做运算

```java
short i = 5; //正确
byte j = 10; //正确
short x = 5 + 10; //正确
short k = i + j; //编译错误
short i = i + 5; //编译错误
short i += 5; //正确，由编译器自己加上强制类型转换
```
