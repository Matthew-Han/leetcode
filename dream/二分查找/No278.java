package 二分查找;

/**
 * @ClassName 二分法.FirstBadVersion
 * @Description #278 第一个错误的版本
 * @Author MatthewHan
 * @Date 2020/5/7 12:50
 * @Version 1.0
 **/
public class No278 {

    /**
     * 二分法考察重点之一！！！！
     * int 值 left 和 right 相加的溢出！！！
     * 记得不要直接相加除以 2，要变式！！！
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("firstBadVersion(4) = " + firstBadVersion(2126753390));
    }

    /**
     * 模拟 api 检测每个版本是否出错
     *
     * @param version
     * @return
     */
    public static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }


    /**
     * 方法一
     * 暴力法，超出时间限制
     *
     * @param n
     * @return
     */
    public static int firstBadVersionByViolence(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i) && !isBadVersion(i - 1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param n
     * @return
     * @date 2021/6/16
     */
    public int firstBadVersionPro(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    /**
     * 方法二
     * 二分法超出时间限制
     * 按照 (left + right) / 2 会超过int的值（因为 int 溢出了，变成了负数，于是怎么算都不对了）
     * 但是这样写 left + (right - left) / 2就不会了。
     * 另外 (left / 2 + right / 2)该变式也是不行的，因为 (3 + 7) / 2 结果是 5 ≠ (3 / 2 + 7 / 2) 结果是 4 ，当两个数为奇数就不对了。
     * <p>
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 29.76% 的用户
     * 内存消耗 : 36.4 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        if (isBadVersion(n) && !isBadVersion(n - 1)) {
            return n;
        }
        int left = 0;
        int right = n;
        while (true) {
            /* if true = 当前节点是坏掉的，所以找更早的版本（find old）*/
            if (isBadVersion(left + (right - left) / 2)) {
                if (!isBadVersion(left + (right - left) / 2 - 1)) {
                    return (left + (right - left) / 2);
                } else {
                    right = left + (right - left) / 2;
                    System.out.println("old - left = " + left);
                    System.out.println("old - right = " + right);
                }
                /* if false = 当前节点正常，所以找之后的版本（find new） */
            } else {
                left = left + (right - left) / 2 + 1;
                System.out.println("left = " + left);
                System.out.println("right = " + right);
            }
        }
    }
}
