package 面试题;

import java.util.*;

/**
 * @ClassName ColorFill
 * @Description 面试题 08.10. 颜色填充
 * @Author MatthewHan
 * @Date 2020/7/28 10:11
 * @Version 1.0
 **/
public class ColorFill {

    static List<String> xy;

    /**
     * bfs广度优先搜索
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 13.67% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        xy = new LinkedList<>();
        bfs(sr, sc, image, newColor);
        System.out.println("xy = " + xy);
        return image;

    }

    public static void bfs(int i, int j, int[][] image, int newColor) {
        System.out.println("xy = " + i + "" + j);
        // 这里可以搞成不等于newColor
        xy.add(i + "" + j);
        if (i - 1 >= 0 && !xy.contains(i - 1 + "" + j) && image[i - 1][j] == image[i][j]) {

            bfs(i - 1, j, image, newColor);

        }
        if (i + 1 < image.length && !xy.contains(i + 1 + "" + j) && image[i + 1][j] == image[i][j]) {

            bfs(i + 1, j, image, newColor);

        }
        if (j - 1 >= 0 && !xy.contains(i + "" + (j - 1)) && image[i][j - 1] == image[i][j]) {

            bfs(i, j - 1, image, newColor);

        }
        if (j + 1 < image[0].length && !xy.contains(i + "" + (j + 1)) && image[i][j + 1] == image[i][j]) {

            bfs(i, j + 1, image, newColor);

        }
        // 这个节点邻接节点都遍历到了，完成使命，变成newColor
        image[i][j] = newColor;
    }

    public static void bfs(int i, int j, int[][] image, int newColor, int ss) {

    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}, {0, 0, 1}}, 1, 1, 2)));
    }
}
