/**
 * @ClassName AverageSalaryExcludingTheMinimumAndMaximumSalary
 * @Description #1491 去掉最低工资和最高工资后的工资平均值
 * @Author MatthewHan
 * @Date 2020/7/15 14:52
 * @Version 1.0
 **/
public class No1491 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : salary) {
            sum += n;
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }

}
