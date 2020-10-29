/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/29 11:05
 **/
public class RemoveKDigits {


    /**
     * #402 移掉K位数字
     * 执行用时： 112 ms , 在所有 Java 提交中击败了 5.10% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 44.90% 的用户
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            char[] curr = sb.toString().toCharArray();
            int index = maxValue(curr);
            sb.delete(index, index + 1);
        }
        return check(sb);
    }

    /**
     * 123456: 删除最后一个
     * 64123 / 65432: 删除第一个
     * 123321: 删除第一个小高峰
     *
     * @param curr
     * @return
     */
    public int maxValue(char[] curr) {
        for (int i = 1; i < curr.length; i++) {
            if (curr[0] > curr[i]) {
                return 0;
            }
            if (i + 1 < curr.length && curr[0] < curr[i] && curr[i] > curr[i + 1]) {
                return i;
            }
        }
        return curr.length - 1;
    }

    public String check(StringBuilder sb) {
        String tmp = sb.toString();
        int index = 0;
        boolean flag = false;
        char[] tmpArray = tmp.toCharArray();
        for (int i = 0; i < tmpArray.length; i++) {
            if (tmpArray[i] != '0') {
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return "0";
        }
        return sb.substring(index, sb.length());
    }

}


