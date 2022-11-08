import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/11/7 15:40 07
 * @since 1.0
 **/
public class No816 {

    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        char[] c = s.toCharArray();
        StringBuilder l = new StringBuilder(s.substring(1, 2));
        StringBuilder r = new StringBuilder(s.substring(2, s.length() - 1));
        for (int i = 2; i < c.length - 1; i++) {
            List<String> left = split(l.toString());
            List<String> right = split(r.toString());
            ans.addAll(left.stream().map(x -> right.stream()
                    .map(v -> "(" + x + ", " + v + ")").collect(Collectors.toList()))
                    .reduce((o1, o2) -> Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toList())).orElse(new ArrayList<>()));
            l.append(c[i]);
            r.deleteCharAt(0);
        }
        return ans;
    }

    public List<String> split(String str) {
        char[] c = str.toCharArray();
        List<String> ans = new ArrayList<>();
        if (str.charAt(0) == '0') {
            if (str.length() == 1) {
                ans.add(str);
            } else if (str.charAt(str.length() - 1) != '0') {
                ans.add(0 + "." + new String(Arrays.copyOfRange(c, 1, str.length())));
            }
            return ans;
        }
        if (str.charAt(str.length() - 1) == '0') {
            if (str.charAt(0) != '0') {
                ans.add(str);
            }
            return ans;
        }
        ans.add(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < c.length; i++) {
            sb.append(c[i - 1]);
            ans.add(sb + "." + new String(Arrays.copyOfRange(c, i, str.length())));
        }
        return ans;
    }
}
