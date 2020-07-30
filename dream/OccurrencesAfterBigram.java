import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName OccurrencesAfterBigram
 * @Description #1078 Bigram 分词
 * @Author MatthewHan
 * @Date 2020/7/6 09:15
 * @Version 1.0
 **/
public class OccurrencesAfterBigram {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 71.30% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public static String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        int i = 0;
        int j = i + 1;
        List<String> list = new ArrayList<>();
        while (j + 1 < arr.length) {
            if (arr[i].equals(first) && arr[j].equals(second)) {
                list.add(arr[j + 1]);
            }
            i++;
            j++;
        }
        return list.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String text = "s a a a good a a girl she is a good student";
        System.out.println(Arrays.toString(findOcurrences(text, "a", "a")));


    }
}
