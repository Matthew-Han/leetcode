/**
 * @ClassName StringCompression
 * @Description #443 压缩字符串
 * @Author MatthewHan
 * @Date 2020/5/15 10:01
 * @Version 1.0
 **/
public class No443 {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 44.00% 的用户
     * 内存消耗 : 39.3 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int j = 0;
        char currElement = chars[0];
        int currCount = 1;
        for (int i = 0; i < chars.length; i++) {
            System.out.println("chars[i] = " + chars[i]);
            System.out.println("currElement = " + currElement);
            System.out.println("currCount = " + currCount);
            System.out.println("i = " + i);
            System.out.println("----------------------");

            if (i + 1 < chars.length && currElement != chars[i + 1] || i + 1 == chars.length) {
                StringBuilder temp = new StringBuilder(String.valueOf(currElement));
                // ['a']该种情况，不需要拼接count，只要a即可，['a', 'a']才是a2
                if (currCount > 1) {
                    temp.append(currCount);
                }
                for (int i1 = 0; i1 < temp.length(); i1++) {
                    chars[j] = temp.charAt(i1);
                    j++;
                }
                currCount = 1;
                // 当前元素移交给下一位
                if (i + 1 != chars.length) {
                    currElement = chars[i + 1];

                }
            } else {
                currCount++;
            }
        }
        System.out.println(chars);
        return j;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'a', 'a', 'a', 'b', 'b', 'v', 'v', 'h'}));
    }
}
