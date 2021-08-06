package input_output_summary.aPlusB;

import java.util.Scanner;

public class G_cyy {
    //输入数据有多组, 每行表示一组输入数据。
    //
    //每行不定有n个整数，空格隔开。(1 <= n <= 100)。
    //in
//1 2 3
//4 5
//0 0 0 0 0

    //out
    //6
    //9
    //0

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            int sum = 0;
            for (int i = 0; i < split.length; i++) {
                sum += Integer.parseInt(split[i]);
            }
            System.out.println(sum);
        }


    }

}
