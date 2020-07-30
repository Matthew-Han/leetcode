import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LongPressedName
 * @Description #925 长按键入
 * @Author MatthewHan
 * @Date 2020/6/23 17:08
 * @Version 1.0
 **/
public class LongPressedName {

    public static List<Integer[]> fucker(String str) {
        if (null == str || "".equals(str)) {
            return new ArrayList<>(0);
        }
        List<Integer[]> list = new ArrayList<>();
        char[] chars = str.toCharArray();

        char prev = chars[0];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (prev == chars[i]) {
                count++;
            } else {
                list.add(new Integer[]{(int) prev, count});
                prev = chars[i];
                count = 1;
            }
            if (i == chars.length - 1) {
                list.add(new Integer[]{(int) prev, count});
            }

        }
        return list;
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 21.82% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {

        List<Integer[]> nameList = fucker(name);
        List<Integer[]> typedList = fucker(typed);

        if (nameList.size() != typedList.size()) {
            return false;
        }
        for (int i = 0; i < typedList.size(); i++) {
            if (!nameList.get(i)[0].equals(typedList.get(i)[0])) {
                return false;
            } else {
                if (nameList.get(i)[1] > typedList.get(i)[1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("aabccbdeffgf", "bbaacccbbddeeffggff"));
    }
}
