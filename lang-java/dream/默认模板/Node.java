package 默认模板;

import java.util.List;

/**
 * @ClassName Node
 * @Description N 叉树公共类
 * @Author MatthewHan
 * @Date 2020/7/31 10:16
 * @Version 1.0
 **/
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

}
