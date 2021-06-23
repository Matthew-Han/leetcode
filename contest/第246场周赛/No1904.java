package 第246场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/21 09:12
 * @since 1.0
 **/
public class No1904 {

    /**
     * #1904 你完成的完整的对局数
     *
     * @param startTime
     * @param finishTime
     * @return
     */
    public int numberOfRounds(String startTime, String finishTime) {
        int sh = Integer.parseInt(startTime.substring(0, 2));
        int fh = Integer.parseInt(finishTime.substring(0, 2));
        int sm = Integer.parseInt(startTime.substring(3, 5));
        int fm = Integer.parseInt(finishTime.substring(3, 5));
        boolean flag = (sh * 60 + sm) > (fh * 60 + fm);
        int ans = 0;
        if (flag) {
            while (sh < 24) {
                int c = 60 - sm;
                if (c >= 60) {
                    ans += 4;
                } else if (c >= 45) {
                    ans += 3;
                } else if (c >= 30) {
                    ans += 2;
                } else if (c >= 15) {
                    ans += 1;
                }
                sm = 0;
                sh++;
            }
            for (int i = 0; i < fh; i++) {
                ans += 4;
            }
            if (fm >= 45) {
                ans += 3;
            } else if (fm >= 30) {
                ans += 2;
            } else if (fm >= 15) {
                ans += 1;
            }
        } else {
            while (sh < fh) {
                int c = 60 - sm;
                if (c >= 60) {
                    ans += 4;
                } else if (c >= 45) {
                    ans += 3;
                } else if (c >= 30) {
                    ans += 2;
                } else if (c >= 15) {
                    ans += 1;
                }
                sh++;
                sm = 0;
            }
            if (sh == fh) {
                if (fm >= 45) {
                    if (sm <= 0) {
                        ans += 3;
                    } else if (sm <= 15) {
                        ans += 2;
                    } else if (sm <= 30) {
                        ans += 1;
                    }
                } else if (fm >= 30) {
                    if (sm <= 0) {
                        ans += 2;
                    } else if (sm <= 15) {
                        ans += 1;
                    }
                } else if (fm >= 15) {
                    if (sm <= 0) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
}
