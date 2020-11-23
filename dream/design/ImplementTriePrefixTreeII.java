package design;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 17:08
 **/
public class ImplementTriePrefixTreeII {

    static class TireTree {

        private boolean isEnd;
        private final TireTree[] data;
        private Character ele;
        private final static int CAPACITY = 26;

        public TireTree(char ele) {
            this.ele = ele;
            this.data = new TireTree[CAPACITY];
            this.isEnd = false;
        }

        @Override
        public String toString() {
            return "TireTree{" +
                    "isEnd=" + isEnd +
                    ", data=" + Arrays.toString(data) +
                    ", ele=" + ele +
                    '}';
        }
    }

    TireTree tireTree;


    /**
     * #208 实现 Trie (前缀树)
     * <p>
     * 执行用时： 37 ms , 在所有 Java 提交中击败了 99.72% 的用户
     * 内存消耗： 48.6 MB , 在所有 Java 提交中击败了 55.22% 的用户
     */
    public ImplementTriePrefixTreeII() {
        tireTree = new TireTree('$');
    }

    private void insert(TireTree tireTree, String target, int index) {
        if (index >= target.length()) {
            return;
        }
        char curr = target.charAt(index);
        TireTree currTree = tireTree.data[curr - 'a'];
        if (currTree == null) {
            tireTree.data[curr - 'a'] = new TireTree(curr);
            currTree = tireTree.data[curr - 'a'];
            currTree.ele = curr;
        }
        if (currTree.ele == curr && index == target.length() - 1) {
            currTree.isEnd = true;
            return;
        }
        insert(currTree, target, index + 1);
    }

    /**
     * 复合查询
     *
     * @param tireTree
     * @param target
     * @param index
     * @param isPrefix 是否是前缀查询
     * @return
     */
    private boolean search(TireTree tireTree, String target, int index, boolean isPrefix) {
        char curr = target.charAt(index);
        TireTree currTree = tireTree.data[curr - 'a'];
        if (currTree == null) {
            return false;
        } else {
            if (currTree.ele == curr) {
                if (index == target.length() - 1) {
                    return isPrefix || currTree.isEnd;

                } else {
                    return search(currTree, target, index + 1, isPrefix);
                }
            } else {
                return false;
            }
        }
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireTree tmp = tireTree;
        insert(tmp, word, 0);
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireTree tmp = tireTree;
        return search(tmp, word, 0, false);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireTree tmp = tireTree;
        return search(tmp, prefix, 0, true);
    }


    public static void main(String[] args) {
        ImplementTriePrefixTreeII tree = new ImplementTriePrefixTreeII();
        tree.insert("apple");
        System.out.println("treeII = " + Arrays.toString(tree.tireTree.data));
        System.out.println(tree.search("apple"));
        System.out.println(tree.search("app"));
        System.out.println(tree.startsWith("app"));
    }

}
