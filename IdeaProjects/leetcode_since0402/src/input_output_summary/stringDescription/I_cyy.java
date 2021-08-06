package input_output_summary.stringDescription;

import java.util.Arrays;
import java.util.Scanner;

public class I_cyy {

    public static void main(String[] args) {
        //多个测试用例，每个测试用例一行。
        //
        //每行通过空格隔开，有n个字符，n＜100
        //对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
        //in
        //a c bb
        //f dddd
        //nowcoder

        //out
        //a bb c
        //dddd f
        //nowcoder

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(" ");

            //处理
            Arrays.sort(strings);
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i]+" ");
            }


            System.out.println();

        }

    }
}
