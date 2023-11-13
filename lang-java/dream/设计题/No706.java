package 设计题;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/15 00:51
 **/
public class No706 {

    int[] data;

    /**
     * #706 设计哈希映射
     * 执行用时： 27 ms , 在所有 Java 提交中击败了 56.65% 的用户
     * 内存消耗： 46.2 MB , 在所有 Java 提交中击败了 9.53% 的用户
     */
    public No706() {
        data = new int[1000001];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        data[key] = value + 1;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return data[key] - 1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        data[key] = 0;
    }
}
