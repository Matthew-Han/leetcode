package 面试题;

/**
 * @ClassName IsUnique
 * @Description 面试题 01.01. 判定字符是否唯一
 * @Author MatthewHan
 * @Date 2020/7/23 11:08
 * @Version 1.0
 **/
public class IsUnique {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
