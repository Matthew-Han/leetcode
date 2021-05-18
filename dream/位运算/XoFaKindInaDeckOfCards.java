package 位运算;

import java.util.*;

/**
 * @ClassName 位运算.XoFaKindInaDeckOfCards
 * @Description #914 卡牌分组
 * @Author MatthewHan
 * @Date 2020/6/23 11:21
 * @Version 1.0
 **/
public class XoFaKindInaDeckOfCards {


    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 32.01% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println("map = " + map);
        Integer[] list = map.values().toArray(new Integer[]{map.size()});
        int min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            // set出现1就肯定GG了，最小也得是2
            if (integer < 2) {
                return false;
            }
            min = Math.min(min, integer);
        }
        // 求最大公约数，从2到set中最小的那个数
        for (int i = 2; i <= min; i++) {
            int count = 0;
            for (Integer integer : list) {
                if (integer % i == 0) {
                    count++;
                }
            }
            if (count == list.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }
}
