package 默认模板;

import java.util.Objects;

/**
 * @ClassName MultiNode
 * @Description 复杂链表
 * @Author MatthewHan
 * @Date 2020/8/24 09:34
 * @Version 1.0
 **/
public class MultiNode {
    public int val;
    public MultiNode next;
    public MultiNode random;

    public MultiNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MultiNode multiNode = (MultiNode) o;
        return val == multiNode.val && next.equals(multiNode.next) && random.equals(multiNode.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
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
