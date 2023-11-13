import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NumberOfSegmentsInAstring
 * @Description #434 字符串中的单词数
 * @Author MatthewHan
 * @Date 2020/5/14 16:38
 * @Version 1.0
 **/
public class No434 {

    /**
     * wdnmd，这 if 逻辑👴自己都看傻了
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 6.04% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] strings = s.split("");
        List<String> list = new ArrayList<>(s.length());
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (!" ".equals(strings[i])) {
                temp.append(strings[i]);
            }
            /*
             * 这里的判断逻辑大概是
             * 当 i 位不是空格，i + 1 是空格，list 添加 temp
             * 当 i 位是最后一位时，有个三目运算，就不用进入 i + 1 了，防止 ArrayIndexOutOfBoundsException
             */
            if (i <= strings.length - 1 && !" ".equals(strings[i]) && (i == strings.length - 1 ? i == strings.length - 1 : (" ".equals(strings[i + 1])))) {
                list.add(temp.toString());
                // 清空临时的temp
                temp.delete(0, temp.length());
            }
        }
        return list.size();
    }

}
