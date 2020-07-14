/**
 * @ClassName ReformatTheString
 * @Description #1417 重新格式化字符串
 * @Author MatthewHan
 * @Date 2020/7/14 11:29
 * @Version 1.0
 **/
public class ReformatTheString {

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 74.03% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static String reformat(String s) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetter(temp)) {
                a.append(temp);
            } else {
                b.append(temp);
            }
        }
        // 长度差2及以上无法格式化
        if (Math.abs(a.length() - b.length()) > 1) {
            return "";
        }
        if (b.length() > a.length()) {
            StringBuilder temp = b;
            b = a;
            a = temp;
        }
        String temp = b.toString();
        int index = 1;
        for (int i = 0; i < b.length(); i++) {
            a.insert(index, temp.charAt(i));
            index += 2;
        }
        return a.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("aaa11111"));
    }
}
