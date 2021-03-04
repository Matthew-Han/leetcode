import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName Counter
 * @Description 查看代码行数
 * @Author MatthewHan
 * @Date 2020/6/12 18:39
 * @Version 1.0
 **/
public class AdreamForTheCounter {



    /**
     * 代码总行数
     */
    private static int i;
    /**
     * 文件个数
     */
    private static int j;

    public static void main(String[] args) throws IOException {
        // 需要统计行数的文件夹路径
        File file = new File("/Users/southerncross/IdeaProjects/leetcode");
        // 调用递归方法查看.java文件，用于统计行数
        traverseFiles(file);
        System.out.println("所写文件个数：" + j);
        System.out.println("所写代码总行数：" + i);


        StringBuilder stringBuilder = new StringBuilder();
        double len = 40000;
        for (double i = 1; i < len; i++) {
            Random random = new Random();
            int r = random.nextInt(26);
            stringBuilder.append((char) (r + 'a'));
        }
        System.out.println("stringBuilder = " + stringBuilder);
        /* ----------------------------------- test ----------------------------------- */

    }


    public static void traverseFiles(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        // 判断是否为文件
        if (!file.isDirectory()) {
            String filename = file.getName();
            // 判断是否是.java文件
            if (filename.endsWith(".java") && !filename.startsWith("AdreamForTheCounter")) {
                j++;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (bufferedReader.readLine() != null) {
                    i++;//读取行数
                }
            } else {
                return;
            }
        }
        // 读取文件夹的子文件或子文件夹
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        // 如果是文件夹递归调用方法遍历文件
        for (File file2 : files) {
            traverseFiles(file2);
        }

    }

}
