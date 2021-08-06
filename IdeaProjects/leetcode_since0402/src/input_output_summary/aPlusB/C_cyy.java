package input_output_summary.aPlusB;

import java.util.Scanner;

public class C_cyy {

    public static void main(String[] args) {

        //输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
        /*in
        *   1 5
            10 20
            0 0

        * */

        /* out
            * 6
            30

        * */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }

    }
}
