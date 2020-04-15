package xyz.yuanmo;

import java.util.Arrays;

/**
 * @ClassName MergeSortedArray
 * @Description #88 合并两个有序数组
 * @Author MatthewHan
 * @Date 2020/4/15 17:15
 * @Version 1.0
 **/
public class MergeSortedArray {

    /**
     * 实际是归并排序的后半段
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        for (int i = 0; i < n; i++) {
            nums1[m] = nums2[i];
            m++;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,4,5,0,0},  4, new int[]{1,7}, 2);

    }
}
