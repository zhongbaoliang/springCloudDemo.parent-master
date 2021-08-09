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
