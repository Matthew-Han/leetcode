package 桶排序;

/**
 * @ClassName ShuffleString
 * @Description #1528 重新排列字符串
 * @Author MatthewHan
 * @Date 2020/8/25 15:25
 * @Version 1.0
 **/
public class No1528 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 31.85% 的用户
     *
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] bucket = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            bucket[indices[i]] = s.charAt(i);
        }
        return new String(bucket);
    }
}
