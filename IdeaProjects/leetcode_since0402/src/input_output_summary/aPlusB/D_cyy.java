package input_output_summary.aPlusB;

import java.util.Scanner;

public class D_cyy {

    public static void main(String[] args) {

        //输入数据包括多组。
        //每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
        //接下来n个正整数,即需要求和的每个正整数。
        /*in
        *   4   1 2 3 4
            5   1 2 3 4 5
            0


        * */

        /* out
            10
            15


        * */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if(num==0)break;
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }

    }
}
