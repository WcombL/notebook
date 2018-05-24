package com.zrkj.algorithm.sort;

/**
 * 选择排序
 * <p>
 * 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 * <p>
 * 选择排序是稳定算法
 * <p>
 * 算法稳定性 - 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的
 */
public class SelectionSort {

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        selectionASC(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    /**
     * 升序排列
     *
     * @param unSort 待排序数组
     * @param len    数组长度
     */
    public static void selectionASC(int[] unSort, int len) {
        // 最小值位置
        int min;

        for (int i = 0; i < len; i++) {
            min = i;

            // 找出未排序区间最小值
            for (int j = i + 1; j < len; j++) {
                if (unSort[j] < unSort[min]) {
                    min = j;
                }
            }

            // 若min!=i，则交换 a[i] 和 a[min]。
            // 交换之后，保证了a[0] ... a[i] 之间的元素是有序的。
            if (min != i) {
                int tmp = unSort[i];
                unSort[i] = unSort[min];
                unSort[min] = tmp;
            }

        }
    }
}
