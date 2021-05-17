package 第52场双周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/15 22:11
 * @description
 * @since 1.0.0
 **/
public class RotatingTheBox {


    /**
     * #5744 旋转盒子
     *
     * @param box
     * @return
     */
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];
        int index = box[0].length;
        for (int i = 0; i < box.length; i++) {
            processor(box[i]);
            for (int j = 0; j < index; j++) {
                ans[j][ans[0].length - 1 - i] = box[i][j];

            }
        }
        return ans;
    }

    public void processor(char[] row) {
        int num = 0;
        int start = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '#') {
                num++;
            } else if (row[i] == '*') {
                for (int j = i - 1; j >= start; j--) {
                    row[j] = num > 0 ? '#' : '.';
                    num--;
                }
                start = i + 1;
                num = 0;

            }
            if (i == row.length - 1) {
                if (num <= 0) {
                    return;
                }
                for (int j = i; j >= start; j--) {
                    row[j] = num > 0 ? '#' : '.';
                    num--;
                }
            }
        }

    }
}
