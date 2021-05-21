package 二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindPositiveIntegerSolutionForaGivenEquation
 * @Description #1237 找出给定方程的正整数解
 * @Author MatthewHan
 * @Date 2020/7/8 15:48
 * @Version 1.0
 **/
public class No1237 {

    /**
     * 经典二分
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 16.67% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param customfunction
     * @param z
     * @return
     */
    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        customfunction = new CustomFunction();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            int left = 1;
            int right = 1000;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (customfunction.f(i, mid) == z) {
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(i);
                    temp.add(mid);
                    list.add(temp);
                    break;
                } else if (customfunction.f(i, mid) > z) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return list;

    }

    public static class CustomFunction {

        public int f(int x, int y) {
            return x + y;
        }
    }
}


