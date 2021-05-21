package 第235场周赛;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/5 02:32
 **/
public class No1816 {

    /**
     * #1816 截断句子
     *
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        String[] tmp = s.split(" ");
        String[] ans = new String[k];
        System.arraycopy(tmp, 0, ans, 0, k);
        StringBuilder sb = new StringBuilder();
        for (String a : ans) {
            sb.append(a);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
