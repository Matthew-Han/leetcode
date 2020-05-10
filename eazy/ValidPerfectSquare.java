/**
 * @ClassName ValidPerfectSquare
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
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 28.75% 的用户
     * 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了 9.52% 的用户
     * @param num
     * @return
     */
    public static boolean isPerfectSquarePro(int num) {
            if (num < 0) {
                return false;
            }
            int[] se = start(String.valueOf(num).length());

            for (int i = se[0]; i <= se[1]; i++) {
                if (i * i == num) {
                    return true;
                }
            }
            return false;
    }

    public static int[] start(int len) {
        int start;
        int end;
        switch (len) {
            case 2:
                start = 1;
                end = 10;
                break;
            case 3:
                start = 10;
                end = 32;
                break;
            case 4:
                start = 30;
                end = 100;
                break;
            case 5:
                start = 100;
                end = 317;
                break;
            case 6:
                start = 300;
                end = 1000;
                break;
            case 7:
                start = 1000;
                end = 3163;
                break;
            case 8:
                start = 3000;
                end = 10000;
                break;
            case 9:
                start = 10000;
                end = 31623;
                break;
            case 10:
                start = 30000;
                end = 100000;
                break;
            default:
                start = 1;
                end = 10;
        }
        System.out.println(start +"ssss"+ end);
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquarePro(93025));
        System.out.println(Math.sqrt(100000));
    }
}
