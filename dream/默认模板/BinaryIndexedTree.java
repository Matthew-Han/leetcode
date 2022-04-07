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

    public void update(int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += lowBit(i);
        }
    }

    public int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowBit(i);
        }
        return res;
    }

    public int sum(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    public int lowBit(int x) {
        return x & -x;
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }

}
