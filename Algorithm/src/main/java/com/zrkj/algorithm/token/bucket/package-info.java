package com.zrkj.algorithm.token.bucket;

/**
 * 算法来进行流量控制
 *
 * 漏桶（Leaky bucket）
 * Leaky bucket 算法有两个版本：
 * as a meter（作为计量工具）
 * as a queue（作为调度队列）
 *
 * 对于溢出数据处理方式：
 * Traffic Shaping: 暂时拦截住上方水的向下流动，等待桶中的一部分水漏走后，再放行上方水
 * Traffic Policing: 溢出的上方水直接抛弃
 *
 *
 * 令牌桶 （Token Bucket)
 * 令牌桶算法的原理是系统会以一个恒定的速度往桶里放入令牌，而如果请求需要被处理，则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务
 *
 * 算法基本过程：
 * 1、假如用户配置的平均发送速率为 r，则每隔 1/r 秒一个令牌被加入到桶中；
 * 2、假设桶最多可以存发 b 个令牌。如果令牌到达时令牌桶已经满了，那么这个令牌会被丢弃；
 * 3、当一个 n 个字节的数据包到达时，就从令牌桶中删除 n 个令牌，并且数据包被发送到网络；
 * 4、如果令牌桶中少于 n 个令牌，那么不会删除令牌，并且认为这个数据包在流量限制之外；
 *
 *
 *
 * 其实 as a queue leaky bucket 算法就是 token bucket 算法的一个特例，平时我们大多数说的漏桶算法就是指 as a queue leaky bucket。
 * 漏桶算法主要目的是控制数据注入到网络的速率，平滑网络上的突发流量。
 * 漏桶算法提供了一种机制，通过它，突发流量可以被整形以便为网络提供一个稳定的流量。
 * 而令牌桶算法能够在限制数据的平均传输速率的同时还允许某种程度的突发传输
 *
 * */