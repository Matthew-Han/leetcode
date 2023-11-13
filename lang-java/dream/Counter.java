/*
 * MIT License
 * <p>
 * Copyright (c) 2021 元末
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName Counter
 * @Description 查看代码行数
 * @Author MatthewHan
 * @Date 2020/6/12 18:39
 * @Version 1.0
 **/
public class Counter {


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
        File file = new File("/Users/matthewhan/IdeaProjects/leetcode");
        // 调用递归方法查看.java文件，用于统计行数
        traverseFiles(file);
        System.out.println("所写文件个数：" + j);
        System.out.println("所写代码总行数：" + i);
    }


    public static void traverseFiles(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        // 判断是否为文件
        if (!file.isDirectory()) {
            String filename = file.getName();
            // 判断是否是.java文件
            if (filename.endsWith(".java") && !filename.startsWith("Counter")) {
                j++;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (bufferedReader.readLine() != null) {
                    // 读取行数
                    i++;
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
