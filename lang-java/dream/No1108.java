/**
 * @ClassName DefangingAnIpAddress
 * @Description #1108 IP 地址无效化
 * @Author MatthewHan
 * @Date 2020/7/6 10:59
 * @Version 1.0
 **/
public class No1108 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 13.04% 的用户
     *
     * @param address
     * @return
     */
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char curr = address.charAt(i);
            if (curr == '.') {
                sb.append("[.]");
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public static String defangIPaddrPro(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddrPro("34.23.32.45"));
    }
}
