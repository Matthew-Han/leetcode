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
public class No299 {

    /**
     * 有史以来最长用时
     * 执行用时 : 1817 ms , 在所有 Java 提交中击败了 5.25% 的用户
     * 内存消耗 : 43.5 MB , 在所有 Java 提交中击败了 5.55% 的用户
     *
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {

        if (secret.isEmpty() && guess.isEmpty()) {
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
        return bulls + "A" + (cows - bulls) + "B";
    }

    /**
     * 2021.11.08
     *
     * @param secret
     * @param guess
     * @return
     */
    public String date20211108(String secret, String guess) {
        int x = bulls(secret, guess);
        return x + "A" + (fakeCows(secret, guess) - x) + "B";
    }

    public int bulls(String secret, String guess) {
        int ans = 0;
        for (int i = 0; i < secret.length(); i++) {
            ans += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return ans;
    }

    public int fakeCows(String secret, String guess) {
        int ans = 0;
        int[] bucket = new int[100];
        for (int i = 0; i < secret.length(); i++) {
            bucket[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < guess.length(); i++) {
            ans += bucket[guess.charAt(i) - '0']-- > 0 ? 1 : 0;
        }
        return ans;
    }
}
