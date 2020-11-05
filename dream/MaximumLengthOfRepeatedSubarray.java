import java.util.Arrays;

/**
 * @ClassName MaximumLengthOfRepeatedSubarray
 * @Description #718 最长重复子数组
 * @Author MatthewHan
 * @Date 2020/8/17 10:21
 * @Version 1.0
 **/
public class MaximumLengthOfRepeatedSubarray {


    int max = 0;

    /**
     * 执行用时： 67 ms , 在所有 Java 提交中击败了 36.40% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 96.86% 的用户
     *
     * @param char1
     * @param char2
     * @return
     */
    public int fuck(int[] char1, int[] char2) {
        int len1 = char1.length;
        int len2 = char2.length;
        int[] tmp = new int[len1 + len2 * 2];
        Arrays.fill(tmp, -1);
        int j = 0;
        for (int i = 0; i < len1; i++) {
            tmp[i + len2] = char1[j++];
        }
        // System.out.println(Arrays.toString(tmp));
        dfs(tmp, char2, 0);
        return max;
    }

    public void dfs(int[] tmp, int[] char2, int index) {
        if (index > tmp.length - char2.length) {
            return;
        }
        int j = 0;
        int c = 0;
        boolean flag = false;
        for (int i = index; i < index + char2.length; i++) {
            if (tmp[i] == char2[j]) {
                flag = true;
                c++;
            } else if (flag && tmp[i] != char2[j]) {
                max = Math.max(max, c);
                c = 0;
                flag = false;
            }
            j++;
        }
        max = Math.max(max, c);
        c = 0;
        dfs(tmp, char2, index + 1);
    }


    public static void main(String[] args) {
        System.out.println(findLength2(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 5, 4}));
        System.out.println(findLength2(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
    }

    /**
     * 滑动窗口2
     * 执行用时： 153 ms , 在所有 Java 提交中击败了 6.95% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 94.74% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static int findLength2(int[] a, int[] b) {
        if (a.length == 1 && a.length == b.length) {
            return a[0] == b[0] ? 1 : 0;
        }
        int len = a.length + b.length * 2 - 2;
        int[] tmp1 = new int[len];
        int[] tmp2 = new int[len];
        for (int i = 0; i < tmp1.length; i++) {
            tmp1[i] = -3;
            tmp2[i] = -3;
        }
        System.arraycopy(a, 0, tmp1, b.length - 1, a.length);
        System.arraycopy(b, 0, tmp2, len - b.length, b.length);

        int max = Integer.MIN_VALUE;
        int size = a.length + b.length - 2;
        for (int i = size; i > 0; i--) {
            int tmpMax = 0;
            for (int k = i; k < i + b.length; k++) {
                if (tmp1[k] != -3 && tmp1[k] == tmp2[k]) {
                    tmpMax++;
                } else {
                    tmpMax = 0;
                }
                max = Math.max(max, tmpMax);
            }

            for (int j = i; j < tmp2.length; j++) {
                tmp2[j - 1] = tmp2[j];
            }
            tmp2[tmp2.length - 1] = -3;
            System.out.println("tmp1 = " + Arrays.toString(tmp1));
            System.out.println("tmp2 = " + Arrays.toString(tmp2));
            System.out.println("----------------");
        }


        return max;
    }

    /**
     * 超出时间限制
     *
     * @param a
     * @param b
     * @return
     */
    public static int findLength(int[] a, int[] b) {
        int min = Math.min(a.length, b.length);
        for (int size = min; size > 0; size--) {
            // 初始化双指针，滑动窗口
            int i1 = 0;
            int j1 = size - 1;
            while (j1 < a.length) {
                int i2 = 0;
                int j2 = size - 1;
                while (j2 < b.length) {
                    int tmp1 = i1;
                    int tmp2 = i2;
                    boolean flag = true;
                    System.out.println("tmp1 = " + tmp1);
                    System.out.println("tmp2 = " + tmp2);
                    for (int i = 0; i < size; i++) {
                        if (a[tmp1++] != b[tmp2++]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return size;
                    }
                    i2++;
                    j2++;
                }
                i1++;
                j1++;
            }
        }
        return 0;
    }


}
