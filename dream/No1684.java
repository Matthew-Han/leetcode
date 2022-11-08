import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/11/8 15:44 08
 * @since 1.0
 **/
public class No1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] vis = new boolean[26];
        for (char c : allowed.toCharArray()) {
            vis[c - 'a'] = true;
        }
        return Arrays.stream(words).map(x ->
                        Arrays.stream(x.split("")).mapToInt(v -> vis[v.charAt(0) - 'a'] ? 1 : 0).allMatch(a -> a == 1))
                .mapToInt(x -> x ? 1 : 0).sum();
    }
}
