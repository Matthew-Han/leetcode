package 双指针;

public class No1768 {

    /**
     * 交替合并字符串
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        char[] ans = new char[word1.length() + word2.length()];
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            ans[i * 2] = word1.charAt(i);
            ans[i * 2 + 1] = word2.charAt(i);
        }
        String max = word1.length() > word2.length() ? word1 : word1.length() == word2.length() ? "" : word2;
        int index = len * 2;
        for (int i = len; i < max.length(); i++) {
            ans[index++] = max.charAt(i);
        }
        return new String(ans);
    }

}
