package 第260场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/30 17:29
 * @since 1.0
 **/
public class No2018 {

    /**
     * 判断单词是否能放入填字游戏内
     *
     * @param board
     * @param word
     * @return
     */
    public boolean placeWordInCrossword(char[][] board, String word) {
        String word0 = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ' && (check(board, i, j, word) || check(board, i, j, word0))) {
                    return true;
                }
                if ((board[i][j] == word.charAt(0) && check(board, i, j, word)) || (board[i][j] == word0.charAt(0) && check(board, i, j, word0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check0(char[][] board, int x, int y, String word) {
        // right
        if (y - 1 >= 0 && board[x][y - 1] != '#') {
            return false;
        }
        if (y + word.length() < board[0].length && board[x][y + word.length()] != '#') {
            return false;
        }
        try {
            for (int i = 0; i < word.length(); i++) {
                if (board[x][y + i] == '#' || (Character.isLetter(board[x][y + i]) && board[x][y + i] != word.charAt(i))) {
                    return false;
                }
            }
            // 越界说明容量不够
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean check1(char[][] board, int x, int y, String word) {
        // left
        if (y + 1 < board[0].length && board[x][y + 1] != '#') {
            return false;
        }
        if (y - word.length() >= 0 && board[x][y - word.length()] != '#') {
            return false;
        }
        try {
            for (int i = 0; i < word.length(); i++) {
                if (board[x][y - i] == '#' || (Character.isLetter(board[x][y - i]) && board[x][y - i] != word.charAt(i))) {
                    return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean check2(char[][] board, int x, int y, String word) {
        // up
        if (x + 1 < board.length && board[x + 1][y] != '#') {
            return false;
        }
        if (x - word.length() >= 0 && board[x - word.length()][y] != '#') {
            return false;
        }
        try {
            for (int i = 0; i < word.length(); i++) {
                if (board[x - i][y] == '#' || (Character.isLetter(board[x - i][y]) && board[x - i][y] != word.charAt(i))) {
                    return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean check3(char[][] board, int x, int y, String word) {
        // down
        if (x - 1 >= 0 && board[x - 1][y] != '#') {
            return false;
        }
        if (x + word.length() < board.length && board[x + word.length()][y] != '#') {
            return false;
        }
        try {
            for (int i = 0; i < word.length(); i++) {
                if (board[x + i][y] == '#' || (Character.isLetter(board[x + i][y]) && board[x + i][y] != word.charAt(i))) {
                    return false;
                }
            }
            // 越界说明容量不够
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean check(char[][] board, int x, int y, String word) {
        return check0(board, x, y, word) || check1(board, x, y, word) || check2(board, x, y, word) || check3(board, x, y, word);
    }

    public static void main(String[] args) {
        No2018 demo = new No2018();
        System.out.println(demo.placeWordInCrossword(new char[][]{{'#', ' ', '#' }, {' ', ' ', '#' }, {'#', ' ', 'c' }}, "ca"));
    }
}
