import java.util.Arrays;

/**
 * @ClassName Heaters
 * @Description #475 供暖器
 * @Author MatthewHan
 * @Date 2020/8/7 16:13
 * @Version 1.0
 **/
public class Heaters {


    public static int findRadius(int[] houses, int[] heaters) {
        // 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 双指针计算最大半径
        int res = 0;
        int i = 0;
        for (int house : houses) {
            for (i = 0; i < heaters.length - 1; i++) {
                // 查找到当前房屋最近的暖器
                if (Math.abs(heaters[i] - house) < Math.abs(heaters[i + 1] - house)) {
                    break;
                }
            }
            // 比较较大半径
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30}));
    }
}
