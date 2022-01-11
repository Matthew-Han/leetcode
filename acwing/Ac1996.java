import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/10 09:37
 * @since 1.0
 **/
public class Ac1996 {

    public static Character[] toCharArray(String src) {
        Character[] ans = new Character[src.length()];
        for (int i = 0; i < src.length(); i++) {
            ans[i] = src.charAt(i);
        }
        return ans;
    }

    public static int compareTo(Character[] o1, Character[] o2) {
        int size = Math.min(o1.length, o2.length);
        for (int i = 0; i < size; i++) {
            if (o1[i] < o2[i]) {
                return -1;
            } else if (o1[i] > o2[i]) {
                return 1;
            }
        }
        return Integer.compare(o1.length, o2.length);
    }

    public static int binarySearch0(List<Character[]> list, Character[] curr) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            Character[] midVal = list.get(mid);
            int c = compareTo(curr, midVal);
            if (c == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }

    public static int binarySearch1(List<Character[]> list, Character[] curr) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            Character[] midVal = list.get(mid);
            int c = compareTo(curr, midVal);
            if (c == -1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 打乱字母
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String[] original = new String[n];
        List<Character[]> ascList = new ArrayList<>();
        List<Character[]> descList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String sub = sc.readLine();
            original[i] = sub;

            Character[] ascCharArray = toCharArray(sub);
            Arrays.sort(ascCharArray);
            ascList.add(ascCharArray);


            Character[] descCharArray = toCharArray(sub);
            Arrays.sort(descCharArray, (o1, o2) -> Character.compare(o2, o1));
            descList.add(descCharArray);

        }
        ascList.sort((o1, o2) -> {
            int size = Math.min(o1.length, o2.length);
            for (int i = 0; i < size; i++) {
                if (o1[i] < o2[i]) {
                    return -1;
                } else if (o1[i] > o2[i]) {
                    return 1;
                }
            }
            return Integer.compare(o1.length, o2.length);
        });

        descList.sort((o1, o2) -> {
            int size = Math.min(o1.length, o2.length);
            for (int i = 0; i < size; i++) {
                if (o1[i] < o2[i]) {
                    return -1;
                } else if (o1[i] > o2[i]) {
                    return 1;
                }
            }
            return Integer.compare(o1.length, o2.length);
        });
        for (String s : original) {
            Character[] curr = toCharArray(s);
            Arrays.sort(curr);

            int v1 = binarySearch0(descList, curr);


            Arrays.sort(curr, (o1, o2) -> Character.compare(o2, o1));
            int v2 = binarySearch1(ascList, curr);

            System.out.println(v1 + 1 + " " + (v2));
        }

    }
}
