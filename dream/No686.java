/**
 * @ClassName RepeatedStringMatch
 * @Description #686 重复叠加字符串匹配
 * @Author MatthewHan
 * @Date 2020/5/25 14:31
 * @Version 1.0
 **/
public class No686 {

    public int repeatedStringMatch(String A, String B) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            cnt++;
        }
        if (sb.toString().contains(B)) {
            return cnt;
        } else if (sb.append(A).toString().contains(B)) {
            return ++cnt;
        } else {
            return -1;
        }
    }
}
