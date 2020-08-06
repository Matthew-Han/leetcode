package tree;

/**
 * @ClassName LowestCommonAncestorOfaBinarySearchTree
 * @Description #235 二叉搜索树的最近公共祖先
 * @Author MatthewHan
 * @Date 2020/8/5 11:24
 * @Version 1.0
 **/
public class LowestCommonAncestorOfaBinarySearchTree {

    /**
     * 这题要根据二叉搜索树的特性来做，什么是二叉搜索树？
     * 1. 节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
     * 2. 节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
     * 3. 左子树和右子树也都是 BST
     * 如果当前节点比pv和qv其中一个小（符合条件），则返回当前节点（一正一负，乘积小于0）也就是满足pv < curr < qv
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int pv = p.val, qv = q.val;
        while ((curr.val - pv) * (curr.val - qv) > 0) {
            curr = curr.val > pv ? curr.left : curr.right;
        }
        return curr;
    }
}
