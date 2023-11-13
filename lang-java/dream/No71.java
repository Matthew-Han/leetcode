import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/6 10:03
 * @since 1.0
 **/
public class No71 {

    /**
     * 简化路径
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        int size = -1;
        while (size != path.length()) {
            size = path.length();
            path = path.replaceAll("//", "/");
        }
        String[] e = path.split("/");
        List<String> arr = new ArrayList<>();
        int cnt = 0;
        for (int i = e.length - 1; i >= 0; i--) {
            if (!".".equals(e[i]) && !"".equals(e[i])) {
                if ("..".equals(e[i])) {
                    cnt++;
                } else {
                    if (cnt > 0) {
                        cnt--;
                    } else {
                        arr.add(e[i]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = arr.size() - 1; i >= 0; i--) {
            sb.append(arr.get(i));
            sb.append("/");
        }
        return sb.length() > 1 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }
}
