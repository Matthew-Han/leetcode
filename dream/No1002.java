import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindCommonCharacters
 * @Description #1002 查找常用字符
 * @Author MatthewHan
 * @Date 2020/7/1 09:13
 * @Version 1.0
 **/
public class No1002 {


    /**
     * 执行用时： 32 ms , 在所有 Java 提交中击败了 9.20% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param arr
     * @return
     */
    public List<String> commonChars(String[] arr) {
        if (arr.length == 1) {
            return new ArrayList<>(Arrays.asList(arr[0].split("")));
        }

        List<String> result = new ArrayList<>();
        List<char[]> list = new ArrayList<>(arr.length * 4 / 3 + 1);
        for (String s : arr) {
            list.add(s.toCharArray());
        }
        char[] start = arr[0].toCharArray();

        for (char c : start) {
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                for (int k = 0; k < list.get(i).length; k++) {
                    if (c == list.get(i)[k]) {
                        count++;
                        list.get(i)[k] = '$';
                        break;
                    }
                }
            }
            if (count == arr.length - 1) {
                result.add(String.valueOf(c));
            }

        }

        return result;
    }

    public static void main(String[] args) {

    }
}
