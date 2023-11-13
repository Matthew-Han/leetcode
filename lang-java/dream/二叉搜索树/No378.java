package 二叉搜索树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KthSmallestElementInaSortedMatrix
 * @Description #378 有序矩阵中第K小的元素
 * @Author MatthewHan
 * @Date 2020/8/14 15:53
 * @Version 1.0
 **/
public class No378 {

    /**
     * 哈哈哈，虽然用时很长，但是自己凭本事写出了在一组无序的向量中，构建一颗 BST！！
     * <p>
     * 执行用时： 167 ms , 在所有 Java 提交中击败了 5.44% 的用户
     * 内存消耗： 45.2 MB , 在所有 Java 提交中击败了 77.59% 的用户
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs2(matrix, matrix.length - 1, 0, visited, tmp);
        System.out.println("tmp = " + tmp);
        TreeNode root = new TreeNode(tmp.get(0));
        // 第一位是root节点，已经 add 了
        for (int i = 1; i < tmp.size(); i++) {
            buildBst(tmp.get(i), root);
        }
        dfs(root, res);
        System.out.println("res = " + res);
        return res.get(k - 1);
    }

    public static void buildBst(int n, TreeNode root) {
        if (n <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(n);
            } else {
                root = root.left;
                buildBst(n, root);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(n);
            } else {
                root = root.right;
                buildBst(n, root);
            }
        }


    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }

    public static void dfs2(int[][] matrix, int x, int y, boolean[][] visited, List<Integer> res) {
        if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && !visited[x][y]) {
            visited[x][y] = true;
            res.add(matrix[x][y]);
            dfs2(matrix, x - 1, y, visited, res);
            dfs2(matrix, x, y + 1, visited, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 2));
        int[][] xx = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        for (int[] ints : xx) {
            for (int i : ints) {
                buildBst(i, root);
            }
        }
        System.out.println("tmp = [1, 5, 9, 10, 11, 13, 12, 13, 15]");
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        System.out.println("res = " + res);
    }


}
