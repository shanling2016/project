# 订餐菜单系统

*环境要求*

* OpenJDK8

* Sqlite3.x

> *本模块仅实现了部分功能, 有些细节可能存在Bug*

*关于数据库*

数据库连接引用了外部Jar包 **sqlite-jdbc-3.30.1.jar** 来实现, 同时本目录下的 **Order.db** 文件为数据元文件, 其结构如下;

```sql
-- 表：dish; 用于储存菜品信息
CREATE TABLE dish (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING (256), price DOUBLE, "like" INT);

-- 表：like; 用于保存点赞记录
CREATE TABLE "like" (cid INT, name STRING (256));

-- 表：shop; 餐袋记录
CREATE TABLE shop (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING (256), cid INT, number INT, price DOUBLE, del_time STRING (6), del_address STRING (256), "create" INT, last INT, status BOOLEAN);
```



