/**
 * @ClassName BulbSwitcher
 * @Description #319 灯泡开关
 * @Author MatthewHan
 * @Date 2020/9/2 18:19
 * @Version 1.0
 **/
public class No319 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 5.22% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 5.52% 的用户
     *
     * @param n
     * @return
     */
    public static int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; (i * i) < n; i++) {
            count++;
        }
        return count;
    }

}
