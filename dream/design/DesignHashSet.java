package design;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/15 00:52
 **/
public class DesignHashSet {
    boolean[] data;

    /**
     * #705 设计哈希集合
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 96.43% 的用户
     * 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 21.66% 的用户
     */
    public DesignHashSet() {
        data = new boolean[1000001];
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return data[key];
    }
}
