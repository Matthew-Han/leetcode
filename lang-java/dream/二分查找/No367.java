package 二分查找;

/**
 * @ClassName 二分法.ValidPerfectSquare
 * @Description #367 有效的完全平方数
 * @Author MatthewHan
 * @Date 2020/5/9 18:01
 * @Version 1.0
 **/
public class No367 {

    /**
     * 执行用时 : 454 ms , 在所有 Java 提交中击败了 5.12% 的用户
     * 内存消耗 : 36.2 MB , 在所有 Java 提交中击败了 9.52% 的用户
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4) {
            return true;
        }
        if (num < 0) {
            return false;
        }
        if (num > 8) {
            int max = num / 3;
            for (int i = 0; i <= max; i++) {
                if (i * i == num) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * int 整数最大是 2 的 31 次方 -1，大约 21 亿，只要根据整数的长度可以确定他的平方根大概落在某个区间
     * 比如 2 位数 [10, 99]，平方根一定是在 [1, 10)，比如三位数 [100, 999]，平方根一定是在 [10, 32)，比如四位数 [1000, 9999]，平方根一定是落在 [31, 100)
     * 当这个数很大的话（最大为 2147483647），相应的区间也会变大
     * 加入了二分法后，可以快速避免。
     * <p>
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.6 MB , 在所有 Java 提交中击败了 9.52% 的用户
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquarePro(int num) {
        int[] se = interval(String.valueOf(num).length());
        int left = se[0];
        int right = se[1];

        while (true) {
            int mid = left + (right - left) / 2;
            System.out.println("left:" + left);
            System.out.println("right:" + right);
            if (mid * mid < num) {
                if (right - left == 1) {
                    return false;
                } else {
                    left = mid;
                }
            } else if (mid * mid == num) {
                return true;
            } else {
                if (right - left == 1) {
                    return false;
                } else {
                    right = mid;
                }
            }
        }
    }

    public static int[] interval(int len) {
        int start;
        int end = switch (len) {
            case 3 -> {
                start = 10;
                yield 32;
            }
            case 4 -> {
                start = 31;
                yield 100;
            }
            case 5 -> {
                start = 100;
                yield 317;
            }
            case 6 -> {
                start = 316;
                yield 1000;
            }
            case 7 -> {
                start = 1000;
                yield 3163;
            }
            case 8 -> {
                start = 3162;
                yield 10000;
            }
            case 9 -> {
                start = 10000;
                yield 31623;
            }
            case 10 -> {
                start = 31622;
                yield 46341;
            }
            default -> {
                start = 1;
                yield 10;
            }
        };
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquarePro(99));
        System.out.println(Math.sqrt(2147483647));

    }
}
