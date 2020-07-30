import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BullsAndCows
 * @Description #299 猜数字游戏
 * @Author MatthewHan
 * @Date 2020/5/8 09:49
 * @Version 1.0
 **/
public class BullsAndCows {

    /**
     * 有史以来最长用时
     * 执行用时 : 1817 ms , 在所有 Java 提交中击败了 5.25% 的用户
     * 内存消耗 : 43.5 MB , 在所有 Java 提交中击败了 5.55% 的用户
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {

        if (secret.length() == 0 && guess.length() == 0) {
            return "0A0B";
        }
        int bulls = 0;
        int cows = 0;

        String[] secretArray = secret.split("");
        String[] guessArray = guess.split("");
        List<String> guessList = new ArrayList<>(guess.length());
        /*
         * 计算bull的数量，假如两者长度有不一致可以用<code>Math.min()</code>取短的防止下标溢出。
         */
        for (int i = 0; i < secret.length(); i++) {
            if (secretArray[i].equals(guessArray[i])) {
                bulls++;
            }
            guessList.add(guess.split("")[i]);
        }

        List<String> list = new ArrayList<>(secret.length());
        list.addAll(Arrays.asList(secretArray).subList(0, secret.length()));
        for (int i = 0; i < secretArray.length; i++) {
            for (int k = 0; k < guessList.size(); k++) {
                if (list.get(i).equals(guessList.get(k))) {
                    cows++;
                    guessList.remove(k);
                    break;
                }
            }
        }
        System.out.println(cows);
        return bulls + "A" + (cows-bulls) + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }
}
