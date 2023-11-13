package 树;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/11 17:40 11
 * @since 1.0
 **/
public class No648 {

    TrieTree node;

    public String replaceWords(List<String> dictionary, String sentence) {
        node = new TrieTree();
        StringBuilder sb = new StringBuilder();
        for (String d : dictionary) {
            build(d.toCharArray(), 0, node);
        }
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            sb.append(check(s.toCharArray(), 0, "", node)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void build(char[] arr, int idx, TrieTree node) {
        char c = arr[idx];
        node.nxt[c - 'a'] = node.nxt[c - 'a'] == null ? new TrieTree() : node.nxt[c - 'a'];
        if (idx == arr.length - 1) {
            node.nxt[c - 'a'].isEnd = true;
            return;
        }
        build(arr, idx + 1, node.nxt[c - 'a']);
    }

    public String check(char[] arr, int idx, String ans, TrieTree node) {
        if (idx > arr.length - 1 || node.nxt[arr[idx] - 'a'] == null) {
            return new String(arr);
        } else {
            return node.nxt[arr[idx] - 'a'].isEnd ? ans + arr[idx] : check(arr, idx + 1, ans + arr[idx], node.nxt[arr[idx] - 'a']);
        }
    }

    public static class TrieTree {

        public boolean isEnd;
        public TrieTree[] nxt;

        public TrieTree() {
            isEnd = false;
            nxt = new TrieTree[26];
        }

        @Override
        public String toString() {
            return "TrieTree{" +
                    "isEnd=" + isEnd +
                    ", nxt=" + Arrays.toString(nxt) +
                    '}';
        }
    }
}
