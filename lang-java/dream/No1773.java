import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/5 17:31
 **/
public class No1773 {
    /**
     * #1773 统计匹配检索规则的物品数量
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey)) {
                if (ruleValue.equals(item.get(0))) {
                    ans++;
                }
            } else if ("color".equals(ruleKey)) {
                if (ruleValue.equals(item.get(1))) {
                    ans++;
                }
            } else {
                if (ruleValue.equals(item.get(2))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
