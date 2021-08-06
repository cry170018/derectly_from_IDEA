package input_output_summary.stringDescription;

import java.util.Arrays;
import java.util.Scanner;

public class K_cyy {

    public static void main(String[] args) {
        //输入有多组测试用例，每组用空格隔开两个整数

        //对于每组数据输出一行两个整数的和
        //in
        //1 1

        //2



        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(a + b);
        }

    }
}

