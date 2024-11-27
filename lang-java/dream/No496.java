import java.util.*;

/**
 * @ClassName NextGreaterElementi
 * @Description #496 下一个更大元素 I
 * @Author MatthewHan
 * @Date 2020/5/18 15:08
 * @Version 1.0
 **/
public class No496 {

    /**
     * 2 个 O(n * n) 时间居然比一个 O(n * n * n) 还长。。
     * 执行用时 : 46 ms , 在所有 Java 提交中击败了 5.93% 的用户
     * 内存消耗 : 63.8 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElementPro(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < nums2.length; j++) {
                list.add(nums2[j]);
            }
            map.put(nums2[i], list);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]).isEmpty()) {
                result[i] = -1;
            }
            for (int j = 0; j < map.get(nums1[i]).size(); j++) {
                // 最后一位
                if (j == map.get(nums1[i]).size() - 1 && map.get(nums1[i]).get(j) < nums1[i]) {
                    result[i] = -1;
                }
                if (map.get(nums1[i]).get(j) > nums1[i]) {
                    result[i] = map.get(nums1[i]).get(j);
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 写过的最大复杂度O(n*n*n)
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 6.84% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length) {
                if (nums2[j] == nums1[i]) {
                    int k = j;
                    if (k == nums2.length - 1) {
                        result[i] = -1;
                    }
                    while (k < nums2.length) {
                        if (k == nums2.length - 1 && nums2[k] < nums1[i]) {
                            result[i] = -1;
                        }
                        if (nums2[k] > nums1[i]) {
                            result[i] = nums2[k];
                            break;
                        }
                        k++;
                    }
                }
                j++;
            }
        }
        return result;
    }
}
