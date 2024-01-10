package 默认模板;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/1/9 16:40:47
 **/
public class TrieNode {

    public boolean isEnd;
    public TrieNode[] next;

    public TrieNode() {
        this.isEnd = false;
        this.next = new TrieNode[26];
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "isEnd=" + isEnd +
                ", next=" + Arrays.toString(next) +
                '}';
    }
}
