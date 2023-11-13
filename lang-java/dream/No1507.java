import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReformatDate
 * @Description #1507 转变日期格式
 * @Author MatthewHan
 * @Date 2020/7/15 17:22
 * @Version 1.0
 **/
public class No1507 {

    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 6.81% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param date
     * @return
     */
    public String reformatDate(String date) {
        String[] monthArr = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> monnnnn = new HashMap<>(16);
        for (int i = 0; i < monthArr.length; i++) {
            String v = (i + 1 < 10 ? "0" + (i + 1) : String.valueOf(i + 1));
            monnnnn.put(monthArr[i], v);
        }
        String[] newDate = date.split(" ");
        String year = newDate[2];
        String month = monnnnn.get(newDate[1]);
        String day = newDate[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < day.length(); i++) {
            char temp = day.charAt(i);
            if (Character.isDigit(temp)) {
                sb.append(temp);
            }
        }
        if (sb.length() == 1) {
            sb.insert(0, 0);
        }
        day = sb.toString();
        return year + "-" + month + "-" + day;
    }

}
