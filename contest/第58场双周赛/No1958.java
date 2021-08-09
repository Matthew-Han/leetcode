package 第58场双周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/9 11:02
 * @since 1.0
 **/
public class No1958 {

    /**
     * 检查操作是否合法
     *
     * @param board
     * @param rMove
     * @param cMove
     * @param color
     * @return
     */
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int row = board.length;
        int column = board[0].length;

        List<Character> tmp = new ArrayList<>();
        // check left
        for (int i = cMove - 1; i >= 0; i--) {
            tmp.add(board[rMove][i]);
        }
        if (check(tmp, color)) {
            return true;
        }

        // check right
        tmp = new ArrayList<>();
        for (int i = cMove + 1; i < column; i++) {
            tmp.add(board[rMove][i]);
        }
        if (check(tmp, color)) {
            return true;
        }

        // check top
        tmp = new ArrayList<>();
        for (int i = rMove - 1; i >= 0; i--) {
            tmp.add(board[i][cMove]);
        }
        if (check(tmp, color)) {
            return true;
        }

        // check bottom
        tmp = new ArrayList<>();
        for (int i = rMove + 1; i < row; i++) {
            tmp.add(board[i][cMove]);
        }
        if (check(tmp, color)) {
            return true;
        }

        // step0
        int newR = rMove - 1;
        int newC = cMove - 1;
        tmp = new ArrayList<>();
        while (newR >= 0 && newC >= 0) {
            tmp.add(board[newR][newC]);
            newR--;
            newC--;
        }
        if (check(tmp, color)) {
            System.out.println(5);
            return true;
        }

        // step1
        newR = rMove + 1;
        newC = cMove + 1;
        tmp = new ArrayList<>();
        while (newR < row && newC < column) {
            tmp.add(board[newR][newC]);
            newR++;
            newC++;
        }
        if (check(tmp, color)) {
            System.out.println(6);
            return true;
        }

        // step2
        newR = rMove - 1;
        newC = cMove + 1;
        tmp = new ArrayList<>();
        while (newR >= 0 && newC < column) {
            tmp.add(board[newR][newC]);
            newR--;
            newC++;
        }
        if (check(tmp, color)) {
            System.out.println(7);
            return true;
        }

        // step3
        newR = rMove + 1;
        newC = cMove - 1;
        tmp = new ArrayList<>();
        while (newR < row && newC >= 0) {
            tmp.add(board[newR][newC]);
            newR++;
            newC--;
        }
        if (check(tmp, color)) {
            System.out.println(8);
            return true;
        }


        return false;
    }

    public boolean check(List<Character> tmp, int color) {
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == color) {
                int cnt = 0;
                for (int j = 0; j < i; j++) {
                    if (tmp.get(j) != color && tmp.get(j) != '.') {
                        cnt++;
                    }
                }
                if (cnt == i && cnt > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
