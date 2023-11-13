package 第56场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/10 22:16
 * @since 1.0
 **/
public class No1927 {


    /**
     * 求和游戏
     *
     * @param num
     * @return
     */
    public boolean sumGame(String num) {
        char[] fuck = num.toCharArray();
        int len = num.length();
        boolean flag = true;
        int left = 0;
        int right = 0;
        int leftNum = 0;
        int rightNum = 0;
        for (int i = 0; i < fuck.length; i++) {
            if (fuck[i] == '?') {
                flag = false;
                if (i < len / 2) {
                    leftNum++;
                } else {
                    rightNum++;
                }
                continue;
            }
            if (i < len / 2) {
                left += fuck[i] - '0';
            } else {
                right += fuck[i] - '0';
            }
        }
        if (flag) {
            return left != right;
        }
        if (leftNum == rightNum) {
            return left != right;
        }
        int min = Math.min(leftNum, rightNum);
        leftNum -= min;
        rightNum -= min;
        int abs = Math.abs(right - left);
        int max = Math.max(leftNum, rightNum);

        if (left < right && leftNum < rightNum) {
            return true;
        }
        if (left > right && leftNum > rightNum) {
            return true;
        }

        while (max > 2) {
            abs -= 9;
            max -= 2;
        }
        if (max == 1) {
            return true;
        }
        if (max == 2) {
            return abs != 9;
        }

        return left != right;
    }


    public static void main(String[] args) {
        No1927 demo = new No1927();
        System.out.println(demo.sumGame("?0?3105????1834??7382?997?3?????7?63116?566?701?065?13?3??38?7?488?????9"));
    }
}
