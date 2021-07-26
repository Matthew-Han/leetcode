/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:49
 * @since 1.0
 **/
public class No1736 {

    /**
     * 替换隐藏数字得到的最晚时间
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {
        char[] fuck = time.toCharArray();
        if (fuck[0] == '?') {
            if (fuck[1] == '?' || fuck[1] <= '3') {
                fuck[0] = '2';
            } else {
                fuck[0] = '1';
            }
        }
        fuck(fuck);
        return new String(fuck);

    }

    public void fuck(char[] fuck) {
        if (fuck[0] == '0' || fuck[0] == '1') {
            fuck[1] = fuck[1] == '?' ? '9' : fuck[1];

        } else {
            fuck[1] = fuck[1] == '?' ? '3' : fuck[1];
        }
        fuck[3] = fuck[3] == '?' ? '5' : fuck[3];
        fuck[4] = fuck[4] == '?' ? '9' : fuck[4];
    }
}
