import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MajorityElement
 * @Description #169 多数元素
 * @Author MatthewHan
 * @Date 2020/4/23 09:52
 * @Version 1.0
 **/
public class No169 {

    /**
     * 投票法，太帅了！！
     * 初始化被选举人（elector）为第一个数，设定count = 1，然后遍历；
     * 当nextValue == elector，count + 1，反之 - 1；
     * 当count == 0时，当存在nextValue时，nextValue成为下一个elector，count = 1；
     * 最终的选举人一定是那个众数
     * <p>
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 83.74% 的用户
     * 内存消耗 : 43.1 MB , 在所有 Java 提交中击败了 5.71% 的用户
     *
     * @param nums
     * @return
     */
    public static int boyerMoore(int[] nums) {
        int count = 1;
        int elector = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == elector) {
                count++;
            } else {
                count--;
            }

            /*
             * 上面的if-else可以改成这样
             * count += (nums[i] == elector) ? 1 : -1;
             */
            if (i + 1 < nums.length && count == 0) {
                elector = nums[i + 1];
            }
        }
        return elector;
    }

    /**
     * 执行用时 : 20 ms , 在所有 Java 提交中击败了 22.01% 的用户
     * 内存消耗 : 43.9 MB , 在所有 Java 提交中击败了 5.71% 的用户
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4 + 1);
        int max = nums.length / 2;
        AtomicInteger result = new AtomicInteger();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.forEach((k, v) -> {
            if (v > max) {
                result.set(k);
            }
        });
        return result.get();
    }

    /**
     * 排序就完事了，排序完去中间的那个一定是众数
     *
     * @param nums
     * @return
     */
    public static int secondMethod(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 该方法超出是时间限制
     *
     * @param nums
     * @return
     */
    public static int thirdMethod(int[] nums) {

        int count = 0;
        int index = (int) (Math.random() * nums.length);
        int fuck = nums[index];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i = " + i);
            System.out.println("num = " + nums[i]);
            System.out.println("fuck = " + fuck);
            if (nums[i] == fuck) {
                count++;
                System.out.println("count = " + count);
                System.out.println("------------");
            }
            if (count > nums.length / 2) {
                return nums[index];
            } else if (i == (nums.length - 1)) {
                System.out.println("============");
                count = 0;
                i = -1;
                index = (int) (Math.random() * nums.length);
                fuck = nums[index];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(thirdMethod(new int[]{2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 3, 2}));
        //map.put(num, map.getOrDefault(num, 0) + 1);
        System.out.println((int) (Math.random() * 5));
    }
}
