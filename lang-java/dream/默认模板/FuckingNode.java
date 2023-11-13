package 默认模板;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/28 09:36
 **/
public class FuckingNode {

    public int val;
    public FuckingNode left;
    public FuckingNode right;
    public FuckingNode next;

    public FuckingNode() {
    }

    public FuckingNode(int val) {
        this.val = val;
    }

    public FuckingNode(int val, FuckingNode left, FuckingNode right, FuckingNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
