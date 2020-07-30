import java.util.*;

/**
 * @ClassName SubdomainVisitCount
 * @Description #811 子域名访问计数
 * @Author MatthewHan
 * @Date 2020/6/17 15:46
 * @Version 1.0
 **/
public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpInfo = domain.split("\\s+");
            String[] frags = cpInfo[1].split("\\.");
            int count = Integer.parseInt(cpInfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String dom : counts.keySet()) {
            ans.add("" + counts.get(dom) + " " + dom);
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"1 mail.com", "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

}
