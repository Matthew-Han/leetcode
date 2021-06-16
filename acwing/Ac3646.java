import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:53
 * @description
 * @since 1.0.0
 **/
public class Ac3646 {

    /**
     * 分水果
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int ans = 0;
            int[] curr = new int[3];
            for (int k = 0; k < 3; k++) {
                curr[k] = sc.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                if (curr[i] > 0) {
                    curr[i] -= 1;
                    ans++;
                }
            }
            ans += fuck(curr);
            System.out.println(curr[0] > 0 && curr[1] > 0 && curr[2] > 0 ? ans + 1 : ans);
        }
    }

    public static int fuck(int[] curr) {
        int[] type1 = curr.clone();
        int ans1 = 0;
        if (type1[0] > 0 && type1[1] > 0) {
            type1[0] -= 1;
            type1[1] -= 1;
            ans1++;
        }
        if (type1[0] > 0 && type1[2] > 0) {
            type1[0] -= 1;
            type1[2] -= 1;
            ans1++;
        }
        if (type1[1] > 0 && type1[2] > 0) {
            type1[1] -= 1;
            type1[2] -= 1;
            ans1++;
        }

        int[] type2 = curr.clone();
        int ans2 = 0;

        if (type2[0] > 0 && type2[2] > 0) {
            type2[0] -= 1;
            type2[2] -= 1;
            ans2++;
        }
        if (type2[0] > 0 && type2[1] > 0) {
            type2[0] -= 1;
            type2[1] -= 1;
            ans2++;
        }
        if (type2[1] > 0 && type2[2] > 0) {
            type2[1] -= 1;
            type2[2] -= 1;
            ans2++;
        }

        int[] type3 = curr.clone();
        int ans3 = 0;

        if (type3[1] > 0 && type3[2] > 0) {
            type3[1] -= 1;
            type3[2] -= 1;
            ans3++;
        }
        if (type3[0] > 0 && type3[1] > 0) {
            type3[0] -= 1;
            type3[1] -= 1;
            ans3++;
        }
        if (type3[0] > 0 && type3[2] > 0) {
            type3[0] -= 1;
            type3[2] -= 1;
            ans3++;
        }
        /* 蠢麻了 */
        if (ans1 >= ans2 && ans1 >= ans3) {
            if (curr[0] > 0 && curr[1] > 0) {
                curr[0] -= 1;
                curr[1] -= 1;
            }
            if (curr[0] > 0 && curr[2] > 0) {
                curr[0] -= 1;
                curr[2] -= 1;
            }
            if (curr[1] > 0 && curr[2] > 0) {
                curr[1] -= 1;
                curr[2] -= 1;
            }
            return ans1;

        }
        if (ans2 >= ans1 && ans2 >= ans3) {
            if (curr[0] > 0 && curr[2] > 0) {
                curr[0] -= 1;
                curr[2] -= 1;
            }
            if (curr[0] > 0 && curr[1] > 0) {
                curr[0] -= 1;
                curr[1] -= 1;
            }
            if (curr[1] > 0 && curr[2] > 0) {
                curr[1] -= 1;
                curr[2] -= 1;
            }
            return ans2;
        }
        if (curr[1] > 0 && curr[2] > 0) {
            curr[1] -= 1;
            curr[2] -= 1;
        }
        if (curr[0] > 0 && curr[1] > 0) {
            curr[0] -= 1;
            curr[1] -= 1;
        }
        if (curr[0] > 0 && curr[2] > 0) {
            curr[0] -= 1;
            curr[2] -= 1;
        }
        return ans3;
    }
}
