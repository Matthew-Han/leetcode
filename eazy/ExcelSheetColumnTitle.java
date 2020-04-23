package xyz.yuanmo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.Arrays;

/**
 * @ClassName ExcelSheetColumnTitle
 * @Description #168 Excel表列名称
 * @Author MatthewHan
 * @Date 2020/4/22 14:48
 * @Version 1.0
 **/
public class ExcelSheetColumnTitle {

    /**
     * 1.不可能出现余26的情况
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        return (n--==0 ) ? "":(convertToTitle(n/26) +(char)(n%26+'A'));
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(25%26);

    }
}
