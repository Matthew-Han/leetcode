package 第256场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 09:39
 * @since 1.0
 **/
public class No1986 {

    int ans = 0x3f3f3f3f;

    /**
     * 完成任务的最少工作时间段
     *
     * @param tasks
     * @param sessionTime
     * @return
     */
    public int minSessions(int[] tasks, int sessionTime) {
        int[] bucket = new int[11];
        for (int task : tasks) {
            bucket[task]++;
        }

        dfs(bucket, 0, sessionTime, 0, tasks.length);
        return ans;
    }

    public void dfs(int[] bucket, int sum, int sessionTime, int cnt, int len) {

        if (len == 0) {
            ans = Math.min(cnt + 1, ans);
            return;
        }
        boolean flag = true;
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] > 0 && i + sum <= sessionTime) {
                flag = false;
                break;
            }
        }
        if (flag) {
            dfs(bucket, 0, sessionTime, cnt + 1, len);
        } else {
            for (int i = 1; i < bucket.length; i++) {
                if (bucket[i] > 0 && i + sum <= sessionTime) {
                    bucket[i]--;
                    dfs(bucket, i + sum, sessionTime, cnt, len - 1);
                    bucket[i]++;
                }

            }
        }

    }
}
