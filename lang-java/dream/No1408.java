import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StringMatchingInAnArray
 * @Description #1408 数组中的字符串匹配
 * @Author MatthewHan
 * @Date 2020/7/13 17:21
 * @Version 1.0
 **/
public class No1408 {

    /**
     * 1. 按照字符串元素长度正序排序
     * 2. 比较是否是子串，j=i+1
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 91.28% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param words
     * @return
     */
    public static List<String> stringMatching(String[] words) {
        Arrays.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        List<String> result = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }
}
