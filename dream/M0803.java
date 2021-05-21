/**
 * @ClassName MagicIndex
 * @Description 面试题 08.03. 魔术索引
 * @Author MatthewHan
 * @Date 2020/7/28 09:27
 * @Version 1.0
 **/
public class M0803 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 46.98% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

}
