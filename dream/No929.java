import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UniqueEmailAddresses
 * @Description #929 独特的电子邮件地址
 * @Author MatthewHan
 * @Date 2020/6/24 14:40
 * @Version 1.0
 **/
public class No929 {

    /**
     * 执行用时： 23 ms , 在所有 Java 提交中击败了 58.41% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmailsPro(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            boolean notHasAt = true;
            boolean notHasPlus = true;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    notHasAt = false;
                }
                if (email.charAt(i) == '+') {
                    notHasPlus = false;
                }
                if (notHasAt && email.charAt(i) != '.' && notHasPlus) {
                    sb1.append(email.charAt(i));
                }
                if (!notHasAt) {
                    sb2.append(email.charAt(i));
                }
            }
            sb1.append(sb2);
            System.out.println("sb1 = " + sb1);
            set.add(sb1.toString());
        }
        return set.size();
    }


    /**
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 37.62% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] temp = email.split("@");
            String prefix = temp[0].split("\\+")[0].replaceAll("\\.", "");
            String suffix = temp[1];
            sb.append(prefix).append("@").append(suffix);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmailsPro(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
