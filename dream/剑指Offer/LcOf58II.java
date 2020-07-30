package 剑指Offer;

/**
 * @ClassName LcOf58II
 * @Description 剑指 Offer #58 - II 左旋转字符串
 * @Author MatthewHan
 * @Date 2020/7/20 14:35
 * @Version 1.0
 **/
public class LcOf58II {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        s += s;
        return s.substring(n, n + len);
    }

    public static void main(String[] args) {

    }
}


