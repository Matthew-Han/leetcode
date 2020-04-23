import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExcelSheetColumnNumber
 * @Description #171 Excel表列序号
 * @Author MatthewHan
 * @Date 2020/4/23 16:10
 * @Version 1.0
 **/
public class ExcelSheetColumnNumber {

    /**
     * 执行用时 : 11 ms , 在所有 Java 提交中击败了 5.56% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.55% 的用户
     *
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {

        String[] origin = s.split("");
        int result = 0;
        int carry = 0;
        for (int i = origin.length - 1; i >= 0; i--) {
            result += ((int) origin[i].charAt(0) - 64) * Math.pow(26, carry);
            carry++;
        }
        return result;

    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 5.55% 的用户
     *
     * @param s
     * @return
     */
    public static int quick(String s) {
        int result = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 64) * Math.pow(26, carry);
            carry++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("titleToNumber = " + quick("Z"));

        System.out.println("Abc".charAt(2));
    }
}
