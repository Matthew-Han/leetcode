package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/25 17:18 25
 * @since 1.0
 **/
public class No1332 {

    /**
     * 删除回文子序列
     *
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString()) ? 1 : 2;

    }
}
