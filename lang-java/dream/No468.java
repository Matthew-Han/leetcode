/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/30 10:21 30
 * @since 1.0
 **/
public class No468 {
    /**
     * 验证IP地址
     *
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            cnt0 += queryIP.charAt(i) == '.' ? 1 : 0;
            cnt1 += queryIP.charAt(i) == ':' ? 1 : 0;
        }
        String[] arr = queryIP.split("\\.");
        if (cnt0 == 3 && arr.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (arr[i].isEmpty() || arr[i].length() > 3) {
                    return "Neither";
                }
                // 前导 0
                if (arr[i].charAt(0) == '0' && arr[i].length() > 1) {
                    return "Neither";
                }
                // 非数字
                for (int j = 0; j < arr[i].length(); j++) {
                    if (!Character.isDigit(arr[i].charAt(j))) {
                        return "Neither";
                    }
                }
                int v = Integer.parseInt(arr[i]);
                // 0 <= xi <= 255
                if (v < 0 || v > 255) {
                    return "Neither";
                }

            }
            return "IPv4";
        } else if (cnt1 == 7) {
            arr = queryIP.split(":");
            if (arr.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < 8; i++) {
                if (arr[i].length() > 4 || arr[i].isEmpty()) {
                    return "Neither";
                }
                for (int j = 0; j < arr[i].length(); j++) {
                    if (!(Character.isDigit(arr[i].charAt(j)) || (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f') || (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F'))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}
