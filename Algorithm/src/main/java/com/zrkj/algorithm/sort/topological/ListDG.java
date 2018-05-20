package com.zrkj.algorithm.sort.topological;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表对应的结构体
 */
public class ListDG {

    // 邻接表中对应的链表的顶点
    private class ENode{
        // 该边所指向的顶点的位置
        int ivex;
        // 指向下一条弧的指针
        ENode nextEdge;

        public int getIvex() {
            return ivex;
        }

        public void setIvex(int ivex) {
            this.ivex = ivex;
        }

        public ENode getNextEdge() {
            return nextEdge;
        }

        public void setNextEdge(ENode nextEdge) {
            this.nextEdge = nextEdge;
        }
    }

    // 邻接表中表的顶点
    private class VNode{
        // 顶点信息
        char data;
        // 指向第一条依附该顶点的弧
        ENode firstEdage;

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public ENode getFirstEdage() {
            return firstEdage;
        }

        public void setFirstEdage(ENode firstEdage) {
            this.firstEdage = firstEdage;
        }
    }

    // 顶点数组
    private VNode[] mVexs;

    public VNode[] getmVexs() {
        return mVexs;
    }

    public void setmVexs(VNode[] mVexs) {
        this.mVexs = mVexs;
    }

    /**
     * 拓扑排序
     *
     * @return
     *  -1 -- 失败(由于内存不足等原因导致)
     *  0 -- 成功排序，并输入结果
     */
    public int topologicalSort(){
        int index = 0;
        int num = mVexs.length;
        int[] ins = new int[num];
        // 入度数组
        char[] tops = new char[num];
        // 拓扑排序结果数组，记录每个节点排序后的序号
        Queue<Integer> queue = new LinkedList<>();

        // 统计每个顶点的入度数
        for (int i = 0; i < num; i++){
            ENode node = mVexs[i].firstEdage;
            while (node != null){
                ins[node.ivex]++;
                node = node.nextEdge;
            }
        }

        //
        return 0;
    }
}
