import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/6 15:25
 * @since 1.0
 **/
public class No1418 {

    /**
     * 点菜展示表
     *
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodTable = new TreeSet<>();
        Map<String, Map<String, Integer>> tableFood = new TreeMap<>((o1, o2) -> Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)));
        for (List<String> order : orders) {
            String tableName = order.get(1);
            String foodName = order.get(2);

            foodTable.add(foodName);

            if (tableFood.containsKey(tableName)) {
                Map<String, Integer> tmp = tableFood.get(tableName);
                tmp.put(foodName, tmp.get(foodName) == null ? 1 : tmp.get(foodName) + 1);
            } else {
                Map<String, Integer> newMap = new HashMap<>();
                newMap.put(foodName, 1);
                tableFood.put(tableName, newMap);
            }

        }
        List<List<String>> ans = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add("Table");
        first.addAll(foodTable);
        ans.add(first);
        for (Map.Entry<String, Map<String, Integer>> e : tableFood.entrySet()) {
            String table = e.getKey();
            List<String> next = new ArrayList<>(first.size());
            next.add(table);
            Map<String, Integer> tableList = e.getValue();
            for (String var1 : foodTable) {
                Integer cnt = tableList.get(var1);
                next.add(cnt == null ? "0" : String.valueOf(cnt));
            }
            ans.add(next);
        }
        return ans;
    }
}
