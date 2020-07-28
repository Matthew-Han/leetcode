package 面试题;

import java.util.Arrays;

/**
 * @ClassName SortedMerge
 * @Description 面试题 10.01. 合并排序的数组
 * @Author MatthewHan
 * @Date 2020/7/28 16:29
 * @Version 1.0
 **/
public class SortedMerge {

    /**
     * 后插法
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 7.88% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param m
     * @param b
     * @param n
     */
    public static void merge3(int[] a, int m, int[] b, int n) {
        int back = a.length - 1;

        for (int i = b.length - 1; i >= 0; i--) {
            int index = m - 1;
            if (index < 0) {
                System.arraycopy(b, 0, a, 0, a.length);
                break;
            }
            if (a[m - 1] < b[i]) {
                a[back] = b[i];
                back--;
            } else {
                while (index > -1 && b[i] < a[index]) {
                    index--;
                }
                for (int j = back; j > index; j--) {
                    a[j] = a[j - 1];
                    if (j - 1 <= 0) {
                        break;
                    }
                }
                a[index + 1] = b[i];
            }
        }
        System.out.println("index = " + Arrays.toString(a));
    }


    /**
     * 二分插入。。拉胯。。
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 27.23% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param m
     * @param b
     * @param n
     */
    public static void merge2(int[] a, int m, int[] b, int n) {
        for (int value : b) {
            int index = binarySearch(a, m++, value);
            System.out.println("index = " + index);
            for (int j = a.length - 1; j > index; j--) {
                a[j] = a[j - 1];
            }
            a[index] = value;
            System.out.println(Arrays.toString(a));
        }
    }

    public static int binarySearch(int[] a, int limit, int n) {
        int left = 0;
        int right = limit - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (mid - 1 >= 0 && mid + 1 < a.length) {
                if (a[mid] < n && a[mid + 1] > n) {
                    return mid + 1;
                }
                if (a[mid - 1] < n && a[mid] > n) {
                    return mid;
                }
            }
        }
        if (a[0] > n) {
            return 0;
        } else if (limit - 1 >= 0 && a[limit - 1] < n) {
            return limit;
        }
        return limit;
    }


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 27.23% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param m
     * @param b
     * @param n
     */
    public void merge(int[] a, int m, int[] b, int n) {
        for (int value : b) {
            a[m++] = value;
        }
        Arrays.sort(a);
    }

    public static void main(String[] args) {

        merge2(new int[]{-12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                1,
                new int[]{-49, -45, -42, -41, -40, -39, -39, -39, -38, -36, -34, -34, -33, -33, -32, -31, -29, -28, -26, -26, -24, -21, -20, -20, -18, -16, -16, -14, -11, -7, -6, -5, -4, -4, -3, -3, -2, -2, -1, 0, 0, 0, 2, 2, 6, 7, 7, 8, 10, 10, 13, 13, 15, 15, 16, 17, 17, 19, 19, 20, 20, 20, 21, 21, 22, 22, 24, 24, 25, 26, 27, 29, 30, 30, 30, 35, 36, 36, 36, 37, 39, 40, 41, 42, 45, 46, 46, 46, 47, 48},
                90);

        merge3(new int[]{1, 2, 4, 5, 6, 0}, 5, new int[]{3}, 1);
        //System.out.println(binarySearch(new int[]{4, 5, 5, 5, 7, 0}, 5, 6));

    }

}
