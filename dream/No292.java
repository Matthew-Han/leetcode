/**
 * @ClassName NimGame
 * @Description #292 Nim 游戏
 * @Author MatthewHan
 * @Date 2020/5/8 09:10
 * @Version 1.0
 **/
public class No292 {

    /**
     * 只要是 4 的整数倍，先手必输（双方都在最优解的情况下）
     * 如何营造一盘完美的胜局呢？
     * 只要保证你拿完的石头数量是4的n倍给对方就行。
     * 永不败的局：一盘4的n倍的石头，你让对面先手，无论他拿几个，你只拿4-n个（即留给对面4的n倍）
     * <p>
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.6 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param n
     * @return
     */
    public static boolean canWinNim(int n) {
        return 0 != n % 4;
    }

    public static void main(String[] args) {
        canWinNim(4);
    }
}
