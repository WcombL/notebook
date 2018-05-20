package com.zrkj.algorithm.sort;

/**
 * 拓扑排序 Topological Order ,将一个有向无环图(Directed Acyclic Graph : DAG)进行排序进而得到一个有序的线性图
 *
 *  基本步骤：
 *  1、构造一个队列Q(queue)和拓扑排序结果队列T(topological)
 *  2、将所有没有依赖顶点的节点放入Q
 *  3、当Q还有顶点的时候执行以下步骤：
 *      3.1、从Q中取出一个顶点n(将n从Q中删除)，并放入T(将n加入结果集中)
 *      3.2、对n的每一个邻节点m(n是起点,m是终点)
 *          3.2.1、去掉边<n,m>
 *          3.2.2、如果m没有依赖顶点,则把m放入Q
 *
 *   注：顶点A没有依赖顶点，是指不存在以A为终点的边。
 */
public class TopologicalOrder {
}
