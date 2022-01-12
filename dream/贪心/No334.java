package 贪心;

import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/12 10:21
 * @since 1.0
 **/
public class No334 {

    /**
     * 前缀和
     *
     * @param nums
     * @return
     */
    public boolean increasingTripletPro(int[] nums) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long[] maxArr = new long[nums.length];
        long[] minArr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            max = Math.max(max, nums[j]);
            maxArr[j] = max;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > minArr[i - 1] && nums[i] < maxArr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递增的三元子序列
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        TreeSet<int[]> set = new TreeSet<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        long min = Long.MAX_VALUE;
        for (int num : nums) {
            boolean flag = false;
            int v = 0;
            for (int[] sub : set) {
                if (num > sub[0]) {
                    if (sub[1] == 2) {
                        return true;
                    } else {
                        flag = true;
                        v = sub[1] + 1;
                        break;
                    }
                }
            }
            if (flag) {
                set.add(new int[]{num, v});
            } else {
                if (num < min) {
                    set.add(new int[]{num, 1});
                    min = Math.min(min, num);
                }
            }
        }
        return false;
    }
}
