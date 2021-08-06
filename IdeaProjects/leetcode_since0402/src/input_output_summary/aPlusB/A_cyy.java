package input_output_summary.aPlusB;

import java.util.Scanner;

public class A_cyy {

    /*
    * in :
    *       1  5  10  20
    * */

    /*
    * out :6
    *       30
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
