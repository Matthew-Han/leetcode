package 位运算;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SingleNumber
 * @Description #136 只出现一次的数字
 * @Author MatthewHan
 * @Date 2020/4/20 14:05
 * @Version 1.0
 **/
public class No136 {


    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }


    /**
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 20.52% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 11.43% 的用户
     *
     * @param nums
     * @return
     */
    public static int singleNumberByMap(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        AtomicInteger fuck = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v == 1) {
                fuck.set(k);
            }
        });
        return fuck.get();

    }


    public static void main(String[] args) {
        /*
         * 二维数组，前一位数字是描述多个这样的大元素在这个最外层的里面
         * 第二位数字是描述一个大元素可以包含多少个小元素
         */

        int[] it = new int[1];
        it = new int[10];
        System.out.println(Arrays.toString(it));
        System.out.println(singleNumberByMap(new int[]{4, 1, 2, 1, 2}));
    }
}
