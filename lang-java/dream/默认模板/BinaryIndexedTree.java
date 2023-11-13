package 默认模板;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/7 16:03 07
 * @since 1.0
 **/
public class BinaryIndexedTree {

    int[] tree;

    public BinaryIndexedTree(int[] arr) {
        this.tree = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]);
        }
    }

    public void update(int idx, int delta) {
        for (int i = idx; i < tree.length; i += lowBit(i)) {
            tree[i] += delta;
        }
    }

    public int query(int idx) {
        int res = 0;
        for (int i = idx; i > 0; i -= lowBit(i)) {
            res += tree[i];
        }
        return res;
    }

    public int query(int left, int right) {
        return query(right + 1) - query(left);
    }

    public int lowBit(int x) {
        return x & -x;
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }

}
