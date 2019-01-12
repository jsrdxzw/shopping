## 一个基于SOA架构的电商项目
### 使用的技术栈包括

___

+ SSM框架
+ mybatis逆向工程，mybatis generator
+ 分页插件
+ nginx负载均衡
+ mysql分库
+ redis三主三从
+ Dubbo + zookeeper

___

该项目实现了主要的电商功能，并没有实现所有的业务功能，如删除，修改操作由于代码重复，没有全部实现

使用了redis数据库缓存了电商首页的数据

后期会使用spring boot和spring cloud进行项目的改造升级