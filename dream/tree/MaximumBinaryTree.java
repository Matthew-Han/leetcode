package tree;

/**
 * @ClassName MaximumBinaryTree
 * @Description #654 最大二叉树
 * @Author MatthewHan
 * @Date 2020/9/4 16:04
 * @Version 1.0
 **/
public class MaximumBinaryTree {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 92.57% 的用户
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = buildTree(nums, left, index - 1);
        node.right = buildTree(nums, index + 1, right);
        return node;

    }


    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{6, 2, 7, 1, 3, 8, 10, 4, 9}, 0, 8));
    }
}
