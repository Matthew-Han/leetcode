package 二维数组;

import java.util.Arrays;

/**
 * @ClassName FindWinnerOnaTicTacToeGame
 * @Description #1275 找出井字棋的获胜者
 * @Author MatthewHan
 * @Date 2020/7/8 17:48
 * @Version 1.0
 **/
public class FindWinnerOnaTicTacToeGame {


    public static String tictactoe(int[][] moves) {
        int len = moves.length;

        int alen = (len & 1) == 0 ? len / 2 : len / 2 + 1;
        int blen = len - alen;
        int[][] a = new int[alen][2];
        int[][] b = new int[blen][2];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < moves.length; i++) {
            if ((i & 1) == 0) {
                a[aIndex] = moves[i];
                aIndex++;
            } else {
                b[bIndex] = moves[i];
                bIndex++;
            }

        }
        System.out.println("a = " + Arrays.deepToString(a));
        System.out.println("b = " + Arrays.deepToString(b));
        return "Draw";
    }

    public static boolean victory(int[][] move) {
        if (move.length < 3) {
            return false;
        }
        // 第一排
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < move.length; i++) {
            for (int j = 0; j < move[i].length; j++) {

            }
        }
    }

    public static void main(String[] args) {
        tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}});
    }
}
