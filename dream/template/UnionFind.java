package template;

import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description 数组模拟树，实现并查集。数组内的元素代表老大的索引值，相当于指针。
 * @since 2021/1/13 10:18
 **/
public class UnionFind {

    /**
     * 数组，表示并查集所有元素
     */
    private final int[] parent;

    /**
     * 初始化并查集
     *
     * @param size
     */
    public UnionFind(int size) {
        // 并查集的元素个数
        // 一开始互不相通，每个并查集都指向自己
        parent = new int[size];
        // 记录树的重量
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查看元素所属于哪个集合
     *
     * @param element 要查看的元素
     * @return element元素所在的集合
     */
    private int find(int element) {
        while (element != parent[element]) {
            // 进行路径压缩
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }
    /**
     * 判断两个元素是否同属于一个集合
     *
     * @param firstElement  第一个元素
     * @param secondElement 第二个元素
     * @return <code>boolean</code> 如果是则返回true。
     */
    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    /**
     * 合并两个元素所在的集合，也就是连接两个元素
     *
     * @param firstElement  第一个元素
     * @param secondElement 第二个元素
     */
    public void union(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        parent[firstRoot] = secondRoot;
    }

}
