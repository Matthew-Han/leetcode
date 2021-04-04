package 第49场双周赛;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/3 22:29
 **/
public class DetermineColorOfaChessboardSquare {

    /**
     * #5705 判断国际象棋棋盘中一个格子的颜色
     *
     * @param coordinates
     * @return
     */
    public static boolean squareIsWhite(String coordinates) {

        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        if (x % 2 == 0 && y % 2 == 0) {
            return false;
        }
        return x % 2 != 1 || y % 2 != 1;
    }

}
