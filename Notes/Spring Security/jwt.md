颁发令牌表示此用户已登录，而不是校验其用户名密码



### 1. JWT令牌结构

- jwt header：说明jwt使用什么算法进行签名/解签

- pay load：携带自定义状态

  - 过期时间
  - 用户名
  - 令牌创建时间

- signature：对前两部分进行签名，防止前两部分被篡改

  > 签名：用存在服务端的密钥对前两部分进行签名，也只有服务端可以解签



以上部分再由base64编码得：

<img src="../img/image-20210827092405915.png" alt="image-20210827092405915" style="zoom: 50%;" /> 



### 2. JWT流程

<img src="../img/image-20210827110825429.png" alt="image-20210827110825429" style="zoom:67%;" /> 



#### 2.1 认证流程

<img src="../img/image-20210827111122405.png" alt="image-20210827111122405" style="zoom:67%;" /> 



#### 2.2 鉴权流程

<img src="../img/image-20210827111811592.png" alt="image-20210827111811592" style="zoom:67%;" /> 
