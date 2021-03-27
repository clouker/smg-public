## 平台简介

* 采用前后端分离的模式
* 后端采用Spring Boot、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos，权限认证使用Redis。
* 流量控制框架选型Sentinel，分布式事务选型Seata。

## 系统模块

~~~   
├── smg-public-ui              // 前端框架 [80]
├── smg-public-gateway         // 网关模块 [8080]
├── smg-public-auth            // 认证中心 [9200]
├── smg-public-api             // 接口模块
│       └── smg-public-api-system                          // 系统接口
├── smg-public-common          // 通用模块
│       └── smg-public-common-core                         // 核心模块
│       └── smg-public-common-datascope                    // 权限范围
│       └── smg-public-common-datasource                   // 多数据源
│       └── smg-public-common-log                          // 日志记录
│       └── smg-public-common-redis                        // 缓存服务
│       └── smg-public-common-security                     // 安全模块
│       └── smg-public-common-swagger                      // 系统接口
├── smg-public-modules         // 业务模块
│       └── smg-public-modules-system                      // 系统模块 [9201]
│       └── smg-public-modules-gen                         // 代码生成 [9202]
│       └── smg-public-modules-job                         // 定时任务 [9203]
│       └── smg-public-modules-file                        // 文件服务 [9300]
├── smg-public-visual          // 图形化管理模块
│       └── smg-public-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
~~~

## 架构图

<img src="https://oscimg.oschina.net/oscnet/up-82e9722ecb846786405a904bafcf19f73f3.png"/>

## 内置功能

1. 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2. 部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3. 岗位管理：配置系统用户所属担任职务。
4. 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5. 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6. 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7. 参数管理：对系统动态配置常用参数。
8. 通知公告：系统通知公告信息发布维护。
9. 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 在线构建器：拖动表单元素生成相应的HTML代码。
17. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 环境部署

准备工作

~~~ 

    JDK >= 1.8 (推荐1.8版本)
    Mysql >= 5.7.0 (推荐5.7版本)
    Redis >= 3.0
    Maven >= 3.0
    Node >= 10
    nacos >= 1.1.0
    sentinel >= 1.6.0
~~~

## 运行系统

后端运行

* 执行数据脚本smg_public_base.sql + quartz.sql（必须），
* 执行数据脚本smg_public_config.sql（必须）
* 集成seata分布式事务（可选配置，默认不启用）
  使用参考<a href='https://doc.ruoyi.vip/ruoyi-cloud/cloud/seata.html#%E9%9B%86%E6%88%90nacos%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83'>集成nacos配置中心</a>
~~~
    执行数据脚本smg_public_seata.sql
~~~

## 模块不知道怎么用的可参考<a href='https://doc.ruoyi.vip/ruoyi-cloud/'>RuoYi-Cloud</a>