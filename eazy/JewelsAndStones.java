/**
 * @ClassName JewelsAndStones
 * @Description #771 宝石与石头
 * @Author MatthewHan
 * @Date 2020/6/16 22:20
 * @Version 1.0
 **/
public class JewelsAndStones {


    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 48.73% 的用户
     * 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param j
     * @param s
     * @return
     */
    public static int numJewelsInStones(String j, String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j.contains(String.valueOf(s.charAt(i)))) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("az", "ZAAbb"));
    }
}
