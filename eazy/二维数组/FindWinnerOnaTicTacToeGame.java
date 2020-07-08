package 二维数组;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FindWinnerOnaTicTacToeGame
 * @Description #1275 找出井字棋的获胜者
 * @Author MatthewHan
 * @Date 2020/7/8 17:48
 * @Version 1.0
 **/
public class FindWinnerOnaTicTacToeGame {


    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 6.13% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     * @param moves
     * @return
     */
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
        if (victory(a)) {
            return "A";
        }
        if (victory(b)) {
            return "B";
        }
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }

    public static boolean victory(int[][] move) {
        if (move.length < 3) {
            return false;
        }
        Set<String> set1 = new HashSet<>(4);
        set1.add("00");
        set1.add("11");
        set1.add("22");
        Set<String> set2 = new HashSet<>(4);
        set2.add("02");
        set2.add("11");
        set2.add("20");


        Set<String> set3 = new HashSet<>(4);
        set3.add("00");
        set3.add("01");
        set3.add("02");
        Set<String> set4 = new HashSet<>(4);
        set4.add("10");
        set4.add("11");
        set4.add("12");
        Set<String> set5 = new HashSet<>(4);
        set5.add("20");
        set5.add("21");
        set5.add("22");

        Set<String> set6 = new HashSet<>(4);
        set6.add("00");
        set6.add("10");
        set6.add("20");
        Set<String> set7 = new HashSet<>(4);
        set7.add("01");
        set7.add("11");
        set7.add("21");
        Set<String> set8 = new HashSet<>(4);
        set8.add("02");
        set8.add("12");
        set8.add("22");

        int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0,g = 0,h = 0;
        for (int[] ints : move) {
            if (set1.contains(ints[0]+""+ints[1])) {
                a++;
            }
            if (set2.contains(ints[0]+""+ints[1])) {
                b++;
            }
            if (set3.contains(ints[0]+""+ints[1])) {
                c++;
            }
            if (set4.contains(ints[0]+""+ints[1])) {
                d++;
            }
            if (set5.contains(ints[0]+""+ints[1])) {
                e++;
            }
            if (set6.contains(ints[0]+""+ints[1])) {
                f++;
            }
            if (set7.contains(ints[0]+""+ints[1])) {
                g++;
            }
            if (set8.contains(ints[0]+""+ints[1])) {
                h++;
            }

            if (a==3||b==3||c==3||d==3||e==3||f==3||g==3||h==3) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
