import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/1 01:42 01
 * @since 1.0
 **/
public class Ac1826 {


    /**
     * 农场缩减
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        TreeSet<int[]> set = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] left0 = new int[]{0x3f3f3f3f, 0x3f3f3f3f};
        int[] left1 = new int[]{0x3f3f3f3f, 0xc0c0c0c0};
        int[] right0 = new int[]{0xc0c0c0c0, 0x3f3f3f3f};
        int[] right1 = new int[]{0xc0c0c0c0, 0xc0c0c0c0};
        int[] top0 = new int[]{0x3f3f3f3f, 0xc0c0c0c0};
        int[] top1 = new int[]{0xc0c0c0c0, 0xc0c0c0c0};
        int[] bottom0 = new int[]{0x3f3f3f3f, 0x3f3f3f3f};
        int[] bottom1 = new int[]{0xc0c0c0c0, 0x3f3f3f3f};
        for (int i = 0; i < n; i++) {
            String[] t = sc.readLine().split(" ");
            int x = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);
            if (x <= left0[0]) {
                if (x < left0[0]) {
                    left0[0] = x;
                    left0[1] = y;

                    left1[0] = x;
                    left1[1] = y;
                } else if (y < left0[1]) {
                    left0[1] = y;
                } else if (y > left1[1]) {
                    left1[0] = x;
                    left1[1] = y;
                }

            }
            if (x >= right0[0]) {
                if (x > right0[0]) {
                    right0[0] = x;
                    right0[1] = y;

                    right1[0] = x;
                    right1[1] = y;
                } else if (y < right0[1]) {
                    right0[1] = y;
                } else if (y > right1[1]) {
                    right1[0] = x;
                    right1[1] = y;
                }
            }
            if (y >= top0[1]) {
                if (y > top0[1]) {
                    top0[0] = x;
                    top0[1] = y;

                    top1[0] = x;
                    top1[1] = y;
                } else if (x < top0[0]) {
                    top0[0] = x;
                } else if (x > top1[0]) {
                    top1[0] = x;
                    top1[1] = y;
                }
            }
            if (y <= bottom0[1]) {
                if (y < bottom0[1]) {
                    bottom0[0] = x;
                    bottom0[1] = y;

                    bottom1[0] = x;
                    bottom1[1] = y;
                } else if (x < bottom0[0]) {
                    bottom0[0] = x;
                } else if (x > bottom1[0]) {
                    bottom1[0] = x;
                    bottom1[1] = y;
                }
            }


            set.add(new int[]{x, y});
        }
        int ans = Integer.MAX_VALUE;

        set.remove(left0);
        ans = Math.min(ans, area(set));
        set.add(left0);

        set.remove(left1);
        ans = Math.min(ans, area(set));
        set.add(left1);

        set.remove(right0);
        ans = Math.min(ans, area(set));
        set.add(right0);

        set.remove(right1);
        ans = Math.min(ans, area(set));
        set.add(right1);

        set.remove(top0);
        ans = Math.min(ans, area(set));
        set.add(top0);

        set.remove(top1);
        ans = Math.min(ans, area(set));
        set.add(top1);

        set.remove(bottom0);
        ans = Math.min(ans, area(set));
        set.add(bottom0);

        set.remove(bottom1);
        ans = Math.min(ans, area(set));
        set.add(bottom1);

        System.out.println(ans);

    }

    public static int area(Set<int[]> set) {
        int minX = 0x3f3f3f3f, minY = 0x3f3f3f3f;
        int maxX = 0xc0c0c0c0, maxY = 0xc0c0c0c0;
        for (int[] xy : set) {
            minX = Math.min(minX, xy[0]);
            minY = Math.min(minY, xy[1]);
            maxX = Math.max(maxX, xy[0]);
            maxY = Math.max(maxY, xy[1]);
        }
        return (maxX - minX) * (maxY - minY);
    }


}
