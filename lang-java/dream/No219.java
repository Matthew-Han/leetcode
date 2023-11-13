/**
 * @ClassName ContainsDuplicateII
 * @Description #219 存在重复元素 II
 * @Author MatthewHan
 * @Date 2020/4/28 16:01
 * @Version 1.0
 **/
public class No219 {

    /**
     * i指针初始化第一位，j指向i+1的位置。i指针每次前进一格，j指针前进k-1格。
     * 在j前进的过程中出现nums[i] == nums[j]返回true。
     * 当i指针每次前进时，j指针指向i+1。只要做好j指针不超数组长度即可。
     * 执行用时 : 876 ms , 在所有 Java 提交中击败了 17.79% 的用户
     * 内存消耗 : 42 MB , 在所有 Java 提交中击败了 51.43% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            while (j < nums.length && j - i <= k) {
                if (nums[i] == nums[j]) {
                    System.out.println(i);
                    System.out.println(j);
                    return true;
                }
                j++;
            }
            if (j - i >= k) {
                i++;
                j = i + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 1}, 2));
    }
}
