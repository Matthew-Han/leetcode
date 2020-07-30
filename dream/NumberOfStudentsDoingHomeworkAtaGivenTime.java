/**
 * @ClassName NumberOfStudentsDoingHomeworkAtaGivenTime
 * @Description #1450 在既定时间做作业的学生人数
 * @Author MatthewHan
 * @Date 2020/7/14 17:33
 * @Version 1.0
 **/
public class NumberOfStudentsDoingHomeworkAtaGivenTime {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }

}
