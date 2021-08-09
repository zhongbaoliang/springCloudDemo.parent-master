IDEA Spring cloud微服务项目搭建(配置中心config/注册中心Eureka/网关路由zuul/网关路由getway)
[图文教程地址](https://www.cnblogs.com/q149072205/p/14081185.html)
项目结构如下
demo.parent
    demo.parent
    springCloud.registry    808 注册中心             http://localhost:808/
    springCloud.config      809 配置中心
    springCloud.zuul        800 路由网关(zuul)       直接访问zuul网关 http://localhost:800/test/page2
    springCloud.geteway     801 路由网关(getway)     直接访问geteway网关 http://localhost:801/test/page2
    demo.webUI              805 系统webUI            http://localhost:805/testUI/page2
                                                    通过zuul: http://localhost:800/webui/testUI/page2
                                                    通过geteway: http://localhost:801/webui/testUI/page2
    demo.webAPI             806 系统WebAPI          http://localhost:806/testAPI/page2
                                                    通过zuul: http://localhost:800/webapi/testAPI/page2
                                                    通过geteway: http://localhost:801/webapi/testAPI/page2
    ...........             可以添加更多的微服务

架构图https://www.cnblogs.com/iUtopia/p/11492072.html
微服务项目各个模块：

注册中心：
系统中各个微服务项目是怎么管理的呢，一般每个微服务都会将自己注册到注册中心，
注册中心负责维护服务名称和服务的关系，一般网关会以服务名的方式获取注册中心中的服务实例完成调用。

网关
微服务开发要把一整个系统不同模块分成不同的服务项目，每个服务都有自己的调用地址端口信息，
那么前端用户怎么调用呢？总不能把所有服务的接口地址给前端吧。
如果需要给所有请求做统一的处理，比如认证、授权方面，也不应该在每个微服务写一套验证逻辑。
在网关服务上做认证授权等公共处理。

负载均衡
很多微服务都会部署多个实例以防止单服务带来的负载压力，比如一些热点的服务，
多实例情况下怎么均匀的把请求分发给各微服务呢？这时候就需要负载均衡器了。

断路器
当某个微服务运行出现问题无法正确调用时，可能出现一直等待直到超时从而占用线程资源的情况，
如何快速响应错误就是断路器的工作了，可以减少服务器资源占用以及快速响应。

服务消费（远程调用）
微服务之间一般需要互相调用，我们进行http调用时一般需要进行创建连接、处理响应信息、
关闭连接等一系列繁琐的处理，服务消费组件就是帮助我们负责处理这些信息，我们只需要简洁的声明即可，
服务消费组件会使用负载均衡器、注册中心、断路器的能力。

配置中心
传统项目的配置信息一般放置在项目文件中，如果配置需要变更，需要去各项目代码里修改，
然后重新部署服务，效率不高，维护多个微服务时更是一件繁琐的事情。
使用配置中心统一管理各服务的配置信息，并且可以实时修改项目配置而无需手动部署。

Eureka，服务注册中心
Zuul，API服务网关
Config，分布式配置中心，支持本地仓库、SVN、Git、Jar包内配置等模式
Dashboard，Hystrix仪表盘，监控集群模式和单点模式，其中集群模式需要收集器Turbine配合
Ribbon，客户端负载均衡
Feign，声明式服务调用
Bus，消息总线



