package leetcode.eazy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SingleNumber
 * @Description #136 只出现一次的数字
 * @Author MatthewHan
 * @Date 2020/4/20 14:05
 * @Version 1.0
 **/
public class SingleNumber {


    /**
     * 暴力法
     * 执行用时 : 443 ms , 在所有 Java 提交中击败了 5.08% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 7.14% 的用户
     * @param nums
     * @return
     */
    public static int violence(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 执行用时 : 1909 ms , 在所有 Java 提交中击败了 5.08% 的用户
     * 内存消耗 : 41.6 MB , 在所有 Java 提交中击败了 5.71% 的用户
     * 利用了集合的方法，但是该方法套娃太多。。反而更慢。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (list.contains(String.valueOf(num))) {
                list.remove(String.valueOf(num));
            } else {
                list.add(String.valueOf(num));
            }
        }
        return Integer.parseInt(list.get(0));
    }


    /**
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 20.52% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 11.43% 的用户
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
        System.out.println(singleNumberByMap(new int[]{4,1,2,1,2}));
    }
}
