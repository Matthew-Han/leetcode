package 深度优先搜索;

import java.math.BigInteger;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/11 09:58
 * @since 1.0
 **/
public class No306 {


    private String num;

    /**
     * 累加数
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        this.num = num;
        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = i + 1; j < num.length() - 1; j++) {
                if (dfs(j + 1, num.substring(0, i + 1), num.substring(i + 1, j + 1))) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int idx, String l, String r) {
        if (idx == num.length()) {
            return true;
        }
        boolean flag = false;
        for (int i = idx; i < num.length(); i++) {
            String c = num.substring(idx, i + 1);
            if (checkPlus(l, r, c)) {
                flag |= dfs(i + 1, r, c);
            }
        }
        return flag;
    }


    public boolean checkPlus(String a, String b, String c) {
        if (check(a) || check(b) || check(c)) {
            return false;
        }
        return new BigInteger(a).add(new BigInteger(b)).equals(new BigInteger(c));
    }

    /**
     * length 不等于 1 时 是否包含前缀 0
     *
     * @param num
     * @return
     */
    public boolean check(String num) {
        return null != num && !"".equals(num) && num.charAt(0) == '0' && num.length() != 1;
    }

}
