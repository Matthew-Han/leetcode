package leetcode.eazy;

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
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.06% 的用户
     * 没学过归并排序，听说这题实际算是小归并排序
     * 看了下图解，尝试写了下，执行用时很满意~
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[m + n];
        while (i < m + n) {
           if (j < m && k != n && nums1[j] <= nums2[k]) {
               temp[i] = nums1[j];
               j++;
           } else if (k < n && j != m && nums2[k] < nums1[j]) {
               temp[i] = nums2[k];
               k++;
           } else if (k < n && j == m){
               temp[i] = nums2[k];
               k++;

           } else if (j < m && k == n){
               temp[i] = nums1[j];
               j++;
           }
           i++;
        }
        // 第一种赋值方法
        for (int i1 = 0; i1 < nums1.length; i1++) {
            nums1[i1] = temp[i1];
        }
        // 第二种赋值方法
        System.arraycopy(temp, 0, nums1, 0, nums1.length);

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},  3, new int[]{2,5,6}, 3);
    }
}
