package 链表;

/**
 * @ClassName MultiNode
 * @Description 复杂链表
 * @Author MatthewHan
 * @Date 2020/8/24 09:34
 * @Version 1.0
 **/
public class MultiNode {
    int val;
    MultiNode next;
    MultiNode random;

    public MultiNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "MultiNode{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
