package input_output_summary.stringDescription;

import java.util.Arrays;
import java.util.Scanner;

public class J_cyy {

    public static void main(String[] args) {
        //多个测试用例，每个测试用例一行。
        //每行通过,隔开，有n个字符，n＜100组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开

        //对于每组用例输出一行排序后的字符串，用','隔开，
        //注意：结尾不能有逗号
        //in
        //a,c,bb
        //f,dddd
        //nowcoder

        //out
        //a,bb,c
        //dddd,f
        //nowcoder

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(",");
            Arrays.sort(strings);
            for (int i = 0; i < strings.length-1; i++) {
                System.out.print(strings[i]+",");
            }
            System.out.println(strings[strings.length-1]);

        }

    }
}
