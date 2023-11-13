package 二维数组;

import java.util.*;

/**
 * @ClassName ThekWeakestRowsInaMatrix
 * @Description #1337 方阵中战斗力最弱的 K 行
 * @Author MatthewHan
 * @Date 2020/7/10 22:28
 * @Version 1.0
 **/
public class No1337 {


    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 28.09% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param mat
     * @param k
     * @return
     */
    public static int[] kWeakestRows(int[][] mat, int k) {

        int[] result = new int[k];
        List<int[][]> list = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int[][] temp = new int[2][2];
            temp[0] = mat[i];
            temp[1] = new int[]{i};
            list.add(temp);
        }
        list.sort(new Comparator<int[][]>() {
            @Override
            public int compare(int[][] o1, int[][] o2) {
                return Integer.compare(oneCount(o1[0]), oneCount(o2[0]));
            }

            public int oneCount(int[] o) {
                int count = 0;
                for (int i : o) {
                    if (i == 0) {
                        break;
                    }
                    count++;
                }
                return count;
            }
        });
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1][0];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 0}}, 4)));
    }
}


