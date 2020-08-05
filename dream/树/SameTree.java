package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SameTree
 * @Description #100 相同的树
 * @Author MatthewHan
 * @Date 2020/8/4 10:57
 * @Version 1.0
 **/
public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        // p and q are both null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);


    }


}
