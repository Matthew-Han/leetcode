package 第31场双周赛;

/**
 * @ClassName MinimumNumberOfIncrementsOnSubarraysToFormAtargetArray
 * @Description #1526 形成目标数组的子数组最少增加次数
 * @Author MatthewHan
 * @Date 2020/7/25 23:36
 * @Version 1.0
 **/
public class MinimumNumberOfIncrementsOnSubarraysToFormAtargetArray {

    /**
     * #4
     * Hard
     * 超出时间限制，这里用了模拟拆砖头😂
     *
     * @param target
     * @return
     */
    public static int minNumberOperations(int[] target) {
        int count = 0;
        while (true) {
            int flag = check(target);
            if (flag != -1) {
                return flag + count;
            }
            count += index(target);
        }
    }

    public static int index(int[] target) {
        int max = Integer.MIN_VALUE;
        for (int n : target) {
            max = Math.max(max, n);
        }
        int prevIndex = -2;
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == max) {
                if (i - 1 != prevIndex) {
                    count++;
                }
                prevIndex = i;
                target[i]--;
            }
        }
        return count;
    }

    public static int check(int[] target) {
        for (int i = 0; i < target.length - 1; i++) {
            if (target[i] != target[i + 1]) {
                return -1;
            }
        }
        return target[0];
    }

    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2}));
    }

}
