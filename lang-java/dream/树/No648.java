package 树;

import 默认模板.TrieNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/11 17:40 11
 * @since 1.0
 **/
public class No648 {

    TrieNode node;

    public String replaceWords(List<String> dictionary, String sentence) {
        node = new TrieNode();
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

    public void build(char[] arr, int idx, TrieNode node) {
        char c = arr[idx];
        node.next[c - 'a'] = node.next[c - 'a'] == null ? new TrieNode() : node.next[c - 'a'];
        if (idx == arr.length - 1) {
            node.next[c - 'a'].isEnd = true;
            return;
        }
        build(arr, idx + 1, node.next[c - 'a']);
    }

    public String check(char[] arr, int idx, String ans, TrieNode node) {
        if (idx > arr.length - 1 || node.next[arr[idx] - 'a'] == null) {
            return new String(arr);
        } else {
            return node.next[arr[idx] - 'a'].isEnd ? ans + arr[idx] : check(arr, idx + 1, ans + arr[idx], node.next[arr[idx] - 'a']);
        }
    }

}
