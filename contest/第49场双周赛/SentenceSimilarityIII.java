package 第49场双周赛;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/3 22:29
 **/
public class SentenceSimilarityIII {

    /**
     * #5706 句子相似性 III
     *
     * @param sentence1
     * @param sentence2
     * @return
     */
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            String tmp = sentence1;
            sentence1 = sentence2;
            sentence2 = tmp;
        }
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }
        String[] strings1 = sentence1.split(" ");
        String[] strings2 = sentence2.split(" ");
        boolean[] vis1 = new boolean[strings1.length];
        boolean[] vis2 = new boolean[strings2.length];
        for (int i = 0; i < strings1.length; i++) {
            if (vis1[i]) {
                continue;
            }
            for (int j = 0; j < strings2.length; j++) {
                if (vis2[j]) {
                    continue;
                }
                if (strings1[i].equals(strings2[j])) {
                    vis1[i] = true;
                    vis2[j] = true;
                    break;
                }
            }
        }
        // 检查 vis2 的覆盖情况
        for (boolean v : vis2) {
            if (!v) {
                return false;
            }
        }
        // false 的段数
        int cnt = 0;
        boolean flag = true;
        for (boolean v : vis1) {
            if (flag && !v) {
                cnt++;
                flag = false;
            }
            if (v) {
                flag = true;
            }
        }
        return cnt < 2;

    }

    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("F A B C D F E", "A D E"));
    }
}
