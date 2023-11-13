package 二分查找;

/**
 * @ClassName LcOf53
 * @Description 剑指 Offer #53 - I 在排序数组中查找数字 I
 * @Author MatthewHan
 * @Date 2020/8/14 11:04
 * @Version 1.0
 **/
public class L53I {


    public static void main(String[] args) {
        System.out.println(search2(new int[]{}, 5));
    }

    /**
     * 双指针，不行；递归，行！
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 43 MB , 在所有 Java 提交中击败了 5.31% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        return dfs(nums, 0, nums.length - 1, target);
    }

    public static int dfs(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return 1 + dfs(nums, left, mid - 1, target) + dfs(nums, mid + 1, right, target);
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;

    }

    /**
     * 先用二分找到目标位置，再双指针展开（有序数组），不过这样有点拉胯
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 29.67% 的用户
     * 内存消耗： 42.5 MB , 在所有 Java 提交中击败了 70.73% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int tmp = mid - 1;
                while (tmp >= 0) {
                    if (nums[tmp--] == target) {
                        count++;
                    }
                }
                while (mid < nums.length) {
                    if (nums[mid++] == target) {
                        count++;
                    }
                }
                return count;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
