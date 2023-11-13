package 树;

import 默认模板.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName BiNode
 * @Description 面试题 17.12. BiNode
 * @Author MatthewHan
 * @Date 2020/8/10 17:00
 * @Version 1.0
 **/
public class M1712 {


    public TreeNode convertBiNode2(TreeNode root) {
        // 单链表的头指针哨兵
        TreeNode head = new TreeNode(0);
        // 移动的链表前置指针
        TreeNode prev = head;
        // 开始中序遍历
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // 链表处理
                // 左指针置空
                node.left = null;
                // 右指针作为链表的next指针
                prev.right = node;
                // 指针后移
                prev = node;

                // 中序遍历进入右子树
                node = node.right;
            }
        }
        return head.right;
    }

    public TreeNode convertRecursionBiNode(TreeNode root) {
        // 单链表的头指针哨兵
        TreeNode head = new TreeNode(0);
        // 开始中序遍历
        inorder(root, head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root, TreeNode prev) {
        if (root != null) {
            prev = inorder(root.left, prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right, prev);
        }
        return prev;
    }
}
