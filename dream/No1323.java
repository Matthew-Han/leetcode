/**
 * @ClassName Maximum69Number
 * @Description #1323 6 和 9 组成的最大数字
 * @Author MatthewHan
 * @Date 2020/7/10 13:14
 * @Version 1.0
 **/
public class No1323 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 81.80% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param num
     * @return
     */
    public static int maximum69Number(int num) {
        String n = String.valueOf(num);
        StringBuilder sb = new StringBuilder(n);
        int index = -1;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '6') {
                index = i;
                break;
            }
        }
        if (index != -1) {
            sb.delete(index, index + 1);
            sb.insert(index, 9);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9696669));
    }
}
