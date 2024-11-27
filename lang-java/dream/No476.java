/**
 * @ClassName NumberComplement
 * @Description #476 数字的补数
 * @Author MatthewHan
 * @Date 2020/5/17 20:46
 * @Version 1.0
 **/
public class No476 {

    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 5.72% 的用户
     * 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        String[] strings = Integer.toBinaryString(num).split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(Integer.parseInt(string) == 1 ? 0 : (Integer.parseInt(string) == 0 ? 1 : 0));
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
