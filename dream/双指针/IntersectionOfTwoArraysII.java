package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 双指针.IntersectionOfTwoArraysII
 * @Description #350 两个数组的交集 II
 * @Author MatthewHan
 * @Date 2020/5/9 14:30
 * @Version 1.0
 **/
public class IntersectionOfTwoArraysII {

    /**
     * 执行用时 : 27 ms , 在所有 Java 提交中击败了 5.80% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(nums1.length);
        List<Integer> list2 = new ArrayList<>(nums2.length);
        List<Integer> list3 = new ArrayList<>(Math.max(nums1.length, nums2.length));
        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }

        for (int i = list1.size() - 1; i >= 0; i--) {
            for (int i1 = list2.size() - 1; i1 >= 0; i1--) {
                if (!list1.isEmpty() && !list2.isEmpty() && list1.get(i).equals(list2.get(i1))) {
                    list3.add(list2.get(i1));
                    list2.remove(i1);
                    break;
                }
            }
        }
        int[] result = new int[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            result[i] = list3.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 1}, new int[]{1, 1})));
    }
}
