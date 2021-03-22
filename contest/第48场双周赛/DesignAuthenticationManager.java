package 第48场双周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/22 09:51
 **/
public class DesignAuthenticationManager {

    int timeToLive;
    Map<String, Integer> data;

    /**
     * #5694 设计一个验证系统
     * 执行用时： 85 ms , 在所有 Java 提交中击败了 36.14% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 35.00% 的用户
     *
     * @param timeToLive
     */
    public DesignAuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        data = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        data.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (!data.containsKey(tokenId)) {
            return;
        }
        int prev = data.get(tokenId) + timeToLive;
        if (currentTime < prev) {
            data.put(tokenId, currentTime);
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() + this.timeToLive > currentTime) {
                ans++;
            }
        }
        return ans;
    }
}
