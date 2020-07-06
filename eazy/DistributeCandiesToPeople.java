import java.util.Arrays;

/**
 * @ClassName DistributeCandiesToPeople
 * @Description #1103 分糖果 II
 * @Author MatthewHan
 * @Date 2020/7/6 10:24
 * @Version 1.0
 **/
public class DistributeCandiesToPeople {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 90.44% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param candies
     * @param numPeople
     * @return
     */
    public static int[] distributeCandies(int candies, int numPeople) {
        int[] arr = new int[numPeople];
        int curr = 1;
        for (int i = 0; i < arr.length; i++) {
            if (candies <= curr) {
                // 最后一次拿糖果，只能拿剩下的那一部分哦~
                arr[i] += candies;
                return arr;
            } else {
                arr[i] += curr;
            }
            if (i == arr.length - 1) {
                i = -1;
            }
            // 剩下的糖果数量
            candies -= curr;
            curr++;

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(2000, 4)));
    }
}
