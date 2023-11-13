import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName ContainsDuplicate
 * @Description #217 存在重复元素
 * @Author MatthewHan
 * @Date 2020/4/28 15:25
 * @Version 1.0
 **/
public class No217 {
    /**
     * 解法1，利用hash表
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 85.65% 的用户
     * 内存消耗 : 42.8 MB , 在所有 Java 提交中击败了 55.81% 的用户
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicateByHash(int[] nums) {
        long startTime = System.currentTimeMillis();
        HashSet<Integer> set = new HashSet<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            set.add(num);
        }
        System.out.println((System.currentTimeMillis() - startTime));

        return nums.length != set.size();

    }

    /**
     * 解法2，利用list
     * 超时时间限制，原因大概是contains方法套娃太多。
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicateByList(int[] nums) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            } else {
                System.out.println((System.currentTimeMillis() - startTime));
                return true;
            }
        }
        System.out.println((System.currentTimeMillis() - startTime));
        return false;

    }


    public static void main(String[] args) {
        int[] ints = new int[10000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        System.out.println(containsDuplicateByHash(ints));
    }
}
