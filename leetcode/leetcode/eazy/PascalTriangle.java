package leetcode.eazy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PascalTriangle
 * @Description #118 杨辉三角
 * @Author MatthewHan
 * @Date 2020/4/16 15:50
 * @Version 1.0
 **/
public class PascalTriangle {

    /**
     * 执行用时 : 19 ms , 在所有 Java 提交中击败了 84.61% 的用户
     * 内存消耗 : 39.6 MB , 在所有 Java 提交中击败了 9.09% 的用户
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lover = new ArrayList<>(numRows);
        if (numRows == 0) {
            return lover;
        }
        List<Integer> fucker = new ArrayList<>(1);
        fucker.add(1);
        lover.add(fucker);
        if (numRows == 1) {
            return lover;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextFucker = new ArrayList<>(numRows);
            for (int j = 0; j < fucker.size(); j++) {
                if (j == 0) {
                    nextFucker.add(1);
                }
                if (j == fucker.size() - 1){
                    nextFucker.add(1);
                }
                if (j + 1 < fucker.size()){
                    nextFucker.add(fucker.get(j) + fucker.get(j + 1));
                }
            }
            fucker = nextFucker;
            lover.add(fucker);
        }
        return lover;
    }

    public static void main(String[] args) {
        System.out.println(generate(0));

    }
}
