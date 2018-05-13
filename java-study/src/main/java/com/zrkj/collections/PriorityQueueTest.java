package com.zrkj.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        int k = 3;
        int parent = (k - 1) >>> 1;
        System.out.println(parent);

        System.out.println("================");

        Queue<Integer> priority = new PriorityQueue<>();

        priority.add(13);
        priority.add(3);
        priority.add(12);
        priority.add(11);
        priority.add(1);

        for (Integer integer : priority) {
            System.out.println(integer);
        }

    }
}
