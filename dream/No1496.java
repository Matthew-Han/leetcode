import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName PathCrossing
 * @Description #1496 判断路径是否相交
 * @Author MatthewHan
 * @Date 2020/7/15 15:01
 * @Version 1.0
 **/
public class No1496 {

    public int getHash(int x, int y) {
        return x * 20001 + y;
    }

    /**
     * 官方题解：自己写一个hash函数，来验证x，y是否曾经走过
     *
     * @param path
     * @return
     */
    public boolean isPathCrossingHash(String path) {
        Set<Integer> vis = new HashSet<>();

        int x = 0, y = 0;
        vis.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N':
                    --x;
                    break;
                case 'S':
                    ++x;
                    break;
                case 'W':
                    --y;
                    break;
                case 'E':
                    ++y;
                    break;
                default:
            }
            int hashValue = getHash(x, y);
            if (!vis.add(hashValue)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 求坐标法，只要出现相同的坐标则走过相同的坐标点
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 20.07% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param path
     * @return
     */
    public static boolean isPathCrossing(String path) {
        int[] xy = new int[]{0, 0};
        HashSet<String> set = new HashSet<>(path.length() * 4 / 3 + 1);
        set.add("" + xy[0] + xy[1]);
        for (int i = 0; i < path.length(); i++) {
            char go = path.charAt(i);
            String newXy;
            if (go == 'N') {
                xy[1]++;
                newXy = "" + xy[0] + xy[1];
            } else if (go == 'S') {
                xy[1]--;
                newXy = "" + xy[0] + xy[1];
            } else if (go == 'E') {
                xy[0]++;
                newXy = "" + xy[0] + xy[1];
            } else {
                xy[0]--;
                newXy = "" + xy[0] + xy[1];
            }
            System.out.println("newXy = " + newXy);
            if (set.contains(newXy)) {
                return true;
            } else {
                set.add(newXy);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NESWW"));
    }
}
