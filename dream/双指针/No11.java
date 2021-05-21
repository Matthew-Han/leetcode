package 双指针;

/**
 * @ClassName ContainerWithMostWater
 * @Description #11 盛最多水的容器
 * @Author MatthewHan
 * @Date 2020/8/9 03:33
 * @Version 1.0
 **/
public class No11 {

    /**
     * 1. 求出最大值和第二大的值（可能与最大值相同）
     * 2. 求出符合这2个值的最两端的两个下标
     * 3. 遍历这两个下标的相反区域，[0 ~ left]，[right ~ length]
     * <p>
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 26.48% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 40.52% 的用户
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int k : height) {
            if (max < k) {
                secondMax = max;
                max = k;
            } else if (max == k) {
                secondMax = k;
            } else {
                secondMax = Math.max(secondMax, k);
            }
        }
        int left = 0;
        int right = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == max || height[i] == secondMax) {
                left = i;
                break;
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] == max || height[i] == secondMax) {
                right = i;
                break;
            }
        }
        // 出现在left的左边和right的右边
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i <= left; i++) {
            for (int j = right; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int l = j - i;
                maxArea = Math.max(maxArea, h * l);
            }
        }
        return maxArea;
    }
}
