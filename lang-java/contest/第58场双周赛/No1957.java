package 第58场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/9 11:02
 * @since 1.0
 **/
public class No1957 {

    /**
     * 删除字符使字符串变好
     *
     * @param s
     * @return
     */
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        char prev = arr[0];
        int cnt = 1;
        StringBuilder stringBuilder = new StringBuilder("" + prev);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev) {
                cnt = 1;
                stringBuilder.append(arr[i]);
            } else {
                if (cnt < 2) {
                    stringBuilder.append(arr[i]);
                }
                cnt++;
            }
            prev = arr[i];
        }
        return stringBuilder.toString();
    }
}
