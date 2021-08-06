package input_output_summary.aPlusB;

import java.util.Scanner;

public class B_cyy {


    //输入第一行包括一个数据组数t(1 <= t <= 100)
    //接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)

    /*
     * in :
     * 2
     *       1  5  10  20
     * */

    /*
     * out :6
     *       30
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayNum = sc.nextInt();
        for (int i = 0; i < arrayNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }

    }
}
