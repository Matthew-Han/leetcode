package 二维数组;

import java.util.Arrays;

/**
 * @ClassName WalkingRobotSimulation
 * @Description #874 模拟行走机器人（待完成）
 * @Author MatthewHan
 * @Date 2020/6/21 02:33
 * @Version 1.0
 **/
public class WalkingRobotSimulation {


    public static void main(String[] args) {
        robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{});
    }

    public static int robotSim(int[] commands, int[][] obstacles) {

        String defaultTowards = "top";
        int[] xy = new int[]{0, 0};
        int[] prevXy = xy;
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] < 0) {
                defaultTowards = towards(defaultTowards, commands[i]);
            } else if ("top".equals(defaultTowards)) {
                xy[1] += commands[i];
                max = Math.max(max, xy[0] * xy[0] + xy[1] * xy[1]);
                prevXy = xy;
            } else if ("bottom".equals(defaultTowards)) {
                xy[1] -= commands[i];
                max = Math.max(max, xy[0] * xy[0] + xy[1] * xy[1]);
                prevXy = xy;
            } else if ("left".equals(defaultTowards)) {
                xy[0] -= commands[i];
                max = Math.max(max, xy[0] * xy[0] + xy[1] * xy[1]);
                prevXy = xy;
            } else if ("right".equals(defaultTowards)) {
                xy[0] += commands[i];
                max = Math.max(max, xy[0] * xy[0] + xy[1] * xy[1]);
                prevXy = xy;
            }
        }
        System.out.println("max = " + max);
        System.out.println("xy = " + Arrays.toString(xy));
        return max;
    }

    public static String towards(String prev, int curr) {
        if ("top".equals(prev)) {
            if (curr == -1) {
                return "right";
            }
            if (curr == -2) {
                return "left";
            }
        }
        if ("left".equals(prev)) {
            if (curr == -1) {
                return "top";
            }
            if (curr == -2) {
                return "bottom";
            }
        }
        if ("right".equals(prev)) {
            if (curr == -1) {
                return "bottom";
            }
            if (curr == -2) {
                return "top";
            }
        }
        if ("bottom".equals(prev)) {
            if (curr == -1) {
                return "left";
            }
            if (curr == -2) {
                return "right";
            }
        }
        return prev;
    }


}
