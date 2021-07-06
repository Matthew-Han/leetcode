import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/6 10:44
 * @since 1.0
 **/
public class No726 {

    /**
     * 原子的数量
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        char[] arr = formula.toCharArray();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && Character.isUpperCase(arr[i]) && !Character.isLowerCase(arr[i + 1])) {
                String k = String.valueOf(arr[i]);
                map.put(k, map.getOrDefault(k, map.get(k) == null ? 0 : map.get(k)) + check(arr, i));

            } else if (i + 1 < arr.length && Character.isUpperCase(arr[i]) && Character.isLowerCase(arr[i + 1])) {
                String k = "" + arr[i] + arr[i + 1];
                map.put(k, map.getOrDefault(k, map.get(k) == null ? 0 : map.get(k)) + check(arr, i + 1));
            }

            if (i == arr.length - 1 && Character.isUpperCase(arr[i])) {
                String k = String.valueOf(arr[i]);
                map.put(k, map.get(k) == null ? 0 : map.get(k) + 1);
            }
        }
        // System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }

    public int check(char[] arr, int index) {
        int cnt = 1;
        int buff = 0;

        if (index + 1 < arr.length) {
            if (arr[index + 1] == '(') {
                index += 2;
                buff--;
            } else {
                StringBuilder tmp = new StringBuilder();
                if (Character.isDigit(arr[index + 1])) {
                    tmp.append(arr[index + 1]);
                    index += 2;
                    while (index < arr.length && Character.isDigit(arr[index])) {
                        tmp.append(arr[index++]);
                    }
                }
                if (tmp.length() > 0) {
                    cnt *= Integer.parseInt(tmp.toString());
                }
            }
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == '(') {
                buff--;
                continue;
            }
            if (i + 1 < arr.length && arr[i] == ')' && Character.isDigit(arr[i + 1])) {
                if (buff >= 0) {
                    StringBuilder tmp = new StringBuilder();
                    if (Character.isDigit(arr[i + 1])) {
                        tmp.append(arr[i + 1]);
                        i += 2;
                        while (i < arr.length && Character.isDigit(arr[i])) {
                            tmp.append(arr[i++]);
                        }
                    }
                    if (tmp.length() > 0) {
                        cnt *= Integer.parseInt(tmp.toString());
                    }
                    i--;
                }
                if (buff < 0) {
                    buff++;
                }
            }
        }
        return cnt;
    }
}
