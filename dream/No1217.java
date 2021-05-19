/**
 * @ClassName PlayWithChips
 * @Description #1217 玩筹码
 * @Author MatthewHan
 * @Date 2020/7/8 10:12
 * @Version 1.0
 **/
public class No1217 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param chips
     * @return
     */
    public static int minCostToMoveChips(int[] chips) {
        int oddCount = 0;
        int evenCount = 0;
        for (int chip : chips) {
            if ((chip & 1) == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(evenCount, oddCount);
    }


    public static void main(String[] args) {
        System.out.println(2 & 1);
    }
}
