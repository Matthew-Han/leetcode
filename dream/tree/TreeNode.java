package tree;

/**
 * @ClassName TreeNode
 * @Description 二叉树公共类
 * @Author MatthewHan
 * @Date 2020/7/29 09:00
 * @Version 1.0
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
