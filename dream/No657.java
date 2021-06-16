import javafx.util.Pair;
import java.util.Map;

/**
 * @ClassName RobotReturnToOrigin
 * @Description #657 机器人能否返回原点
 * @Author MatthewHan
 * @Date 2020/5/23 17:53
 * @Version 1.0
 **/
public class No657 {


    public static boolean judgeCircle2(String moves) {

        int rl = 0;
        int ud = 0;

        for (int i = 0; i < moves.length(); i++) {
            char curr = moves.charAt(i);
            if (curr == 'R') {
                rl++;
            } else if (curr == 'L') {
                rl--;
            } else if (curr == 'U') {
                ud++;
            } else {
                ud--;
            }
        }
        return rl == ud && rl == 0;

    }

    public static void main(String[] args) {
        System.out.println((int) 'R');
        System.out.println((int) 'L');
        System.out.println((int) 'U');
        System.out.println((int) 'D');
    }


    /**
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 97.52% 的用户
     * 内存消耗 : 39.6 MB , 在所有 Java 提交中击败了 11.11% 的用户
     *
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                lr++;
            }
            if (c == 'L') {
                lr--;
            }
            if (c == 'U') {
                ud++;
            }
            if (c == 'D') {
                ud--;
            }
        }
        return lr == 0 && ud == 0;
    }


}
