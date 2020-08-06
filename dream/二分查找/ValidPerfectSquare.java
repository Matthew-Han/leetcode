package 二分查找;

/**
 * @ClassName 二分法.ValidPerfectSquare
 * @Description #367 有效的完全平方数
 * @Author MatthewHan
 * @Date 2020/5/9 18:01
 * @Version 1.0
 **/
public class ValidPerfectSquare {

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
     * int整数最大是2的31次方-1，大约21亿，只要根据整数的长度可以确定他的平方根大概落在某个区间
     * 比如2位数[10, 99]，平方根一定是在[1, 10)，比如三位数[100, 999]，平方根一定是在[10, 32)，比如四位数[1000, 9999]，平方根一定是落在[31, 100)
     * 当这个数很大的话（最大为2147483647），相应的区间也会变大
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
        int end;
        switch (len) {
            case 3:
                start = 10;
                end = 32;
                break;
            case 4:
                start = 31;
                end = 100;
                break;
            case 5:
                start = 100;
                end = 317;
                break;
            case 6:
                start = 316;
                end = 1000;
                break;
            case 7:
                start = 1000;
                end = 3163;
                break;
            case 8:
                start = 3162;
                end = 10000;
                break;
            case 9:
                start = 10000;
                end = 31623;
                break;
            case 10:
                start = 31622;
                end = 46341;
                break;
            default:
                start = 1;
                end = 10;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquarePro(99));
        System.out.println(Math.sqrt(2147483647));

    }
}
