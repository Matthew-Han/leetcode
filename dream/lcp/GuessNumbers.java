package lcp;

/**
 * @ClassName GuessNumbers
 * @Description #LCP 01 猜数字
 * @Author MatthewHan
 * @Date 2020/7/15 17:49
 * @Version 1.0
 **/
public class GuessNumbers {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
