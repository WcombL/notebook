# Lettuce 

基于 netty，支持事件模型
支持 同步、异步、响应式 的方式
可以方便的连接 Redis Sentinel
完全支持 Redis Cluster
SSL 连接
Streaming API
CDI 和 Spring 的集成
兼容 Java 8 和 9


（1）多线程共享
Jedis 是直连模式，在多个线程间共享一个 Jedis 实例时是线程不安全的，如果想要在多线程环境下使用 Jedis，需要使用连接池，每个线程都去拿自己的 Jedis 实例，当连接数量增多时，物理连接成本就较高了。

Lettuce 是基于 netty 的，连接实例可以在多个线程间共享，所以，一个多线程的应用可以使用一个连接实例，而不用担心并发线程的数量。

（2）异步
异步的方式可以让我们更好的利用系统资源，而不用浪费线程等待网络或磁盘I/O。

Lettuce 是基于 netty 的，netty 是一个多线程、事件驱动的 I/O 框架，所以 Lettuce 可以帮助我们充分利用异步的优势。


3）很好的支持 Redis Cluster
对 Cluster 的支持包括：

支持所有的 Cluster 命令

基于哈希槽的命令路由

对 cluster 命令的高层抽象

在多节点上执行命令

根据槽和地址端口直接连接cluster中的节点

SSL和认证

cluster 拓扑的更新

发布/订阅

（4）Streaming API
Redis 中可能会有海量的数据，当你获取一个大的数据集合时，有可能会被撑爆，Lettuce 可以让我们使用流的方式来处理。

