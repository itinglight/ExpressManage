properties式语法描述


```java
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.show-sql= true

server.port=8181 
```



```java
# properties式语法描述
spring.datasource.name = mysql
spring.datasource.url = jdbc:mysql://localhost:3306/db?characterEncoding=utf-8
spring.datasource.username = root
spring.datasource.password = 123
# yml式语法描述
spring:
    datasource:
        name: mysql
        url: jdbc:mysql://localhost:3306/db?characterEncoding=utf-8
        username: root
        password: 123
```



yml式语法描述

```
spring:
	datasource:
		url:jdbc:mysql://localhost:3306/student
		username:root
		password:
	
server:
	port:8182
```

配置pom.xml文件

```
        <!-- spring web mvc -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!-- mysql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```

```
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.show-sql= true

server.port=8181 

```

```java
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/student
    username: root
    driver-class-name: com.mysql.cj.jdbc.Driver



server:
  port: 8081
```

# 5.18

后端

```java
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/student
    username: root
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    properties:
      hibernate:
        hbm2ddl:
          auto: create
        dialect=org:
          hibernate:
            dialect:
              MySQL5InnoDBDialect:
    show-sql: true

server:
  port: 8081
```

