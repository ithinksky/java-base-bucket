package com.ithinksky.java.n03io;

import java.io.*;
import java.util.LinkedList;

/**
 * 有一个文件A，将文件A中的内容进行下面的转换后，输出至文件B：
 * 如果A中的内容有换行，那么取消换行，用,来表示
 * 如果A中的内容有逗号，那么可以用",来表示；
 * 如果A中的内容双引号，那么用连续两个双引号来表示；
 * 如果A中的内容在''中间，则表示特殊引用，那么不进行任何转换直接输出；
 * 附加：
 * 将文件B的内容还原成文件A'：在此背景下，需要考虑原A内容存在于''的情况，可以在A->B转换中，生成一个备注log文件C来辅助；
 *
 * A文件：
 * hello
 * 张三,
 * 你好的"
 * '阿斯蒂芬"藏三,你好啊'
 * '张登,你好啊',很好啊”'
 *
 * B文件：
 * hello,张三",你好的"",'阿斯蒂芬"藏三,你好啊''张登,你好啊'"很好啊”'
 *
 * @author tengpeng.gao
 */
public class TestFile {

    public static void main(String[] args) {
        handleFile();
    }

    public static void handleFile() {
        File file = new File("E:\\IdeaProjects\\java-base-bucket\\A.txt");
        FileInputStream fis = null;

        File outFile = new File("E:\\IdeaProjects\\java-base-bucket\\B.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);

            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
            String s = sb.substring(0, sb.lastIndexOf("\n"));

            char[] chars = s.toCharArray();
            int length = chars.length;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                if (chars[i] == '\'') {
                    list.add(i);
                }
            }
            System.out.println(" ==== list : " + list);
            int size = list.size();
            if (size % 2 == 1) {
                list.removeLast();
            }

            StringBuilder resultSb = new StringBuilder();
            int len = size / 2;
            for (int i = 0; i < len; i++) {
                int start = 0;
                if (list.size() != 0) {
                    start = list.removeFirst();
                }
                if (i == 0 && start != 0) {
                    String common = TestFile.common(s.substring(0, start));
                    System.out.println("common ==== " + common);
                    resultSb.append(common);
                }
                if (list.size() != 0) {
                    int end = list.removeFirst();
                    String substring = s.substring(start, end + 1);
                    System.out.println(" substring ===: " + substring);
                    resultSb.append(substring);
                    if (i == len - 1) {
                        substring = s.substring(end + 1);
                        String common = TestFile.common(substring);
                        System.out.println("common ==== " + common);
                        resultSb.append(common);
                    }
                }
            }


            // ===================================================================
            // * 附加：TODO
            // * 将文件B的内容还原成文件A'：在此背景下，需要考虑原A内容存在于''的情况，可以在A->B转换中，生成一个备注log文件C来辅助；

            fos.write(resultSb.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String common(String s) {
        // 2 如果A中的内容双引号，那么用连续两个双引号来表示；
        if (s.contains("\"")) {
            s = s.replace("\"", "\"\"");
        }
        // 3 如果A中的内容有逗号，那么可以用",来表示；
        if (s.contains(",")) {
            s = s.replace(",", "\"");
        }
        // 4 如果A中的内容有换行，那么取消换行，用,来表示
        s = s.replace("\n", ",");
        return s;
    }

}
