/**
 * @ClassName StringRotation
 * @Description 面试题 01.09. 字符串轮转
 * @Author MatthewHan
 * @Date 2020/7/23 15:45
 * @Version 1.0
 **/
public class M0109 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (null == s2 || "".equals(s1) || "".equals(s2)) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
