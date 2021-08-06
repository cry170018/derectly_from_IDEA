package input_output_summary.aPlusB;

import java.util.Scanner;

public class F_cyy {
    //输入数据有多组, 每行表示一组输入数据。
    //每行的第一个整数为整数的个数n(1 <= n <= 100)。
    //接下来n个正整数, 即需要求和的每个正整数。
    //in
    //4 1 2 3 4
    //5 1 2 3 4 5

    //out
    //10
    //15

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }


    }

}
