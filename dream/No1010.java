/**
 * @ClassName PairsOfSongsWithTotalDurationsDivisibleBy60
 * @Description #1010 总持续时间可被 60 整除的歌曲
 * @Author MatthewHan
 * @Date 2020/7/1 15:11
 * @Version 1.0
 **/
public class No1010 {

    /**
     * 超出时间限制
     *
     * @param time
     * @return
     */
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numPairsDivisibleBy60Pro(int[] time) {
        int ans = 0;
        int[] index = new int[60];
        for (int t : time) {
            ans += index[(60 - t % 60) % 60];
            index[t % 60]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60Pro(new int[]{30, 20, 150, 100, 40}));
    }
}
