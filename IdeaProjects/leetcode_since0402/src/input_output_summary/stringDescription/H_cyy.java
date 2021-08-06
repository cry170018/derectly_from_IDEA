package input_output_summary.stringDescription;

import java.util.Arrays;
import java.util.Scanner;

public class H_cyy {

    public static void main(String[] args) {
        //输入有两行，第一行n
        //
        //第二行是n个用空格隔开的字符串
        //输出排序后的字符串
        //in
        //5
        //c d a bb e

        //out
        //a bb c d e

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();//读完这个数以后，指针还在数字后面的回车前，所以做一个nextline跳到下一行
//        while (sc.hasNext()) {//处理多个case
//            String[] strings = sc.nextLine().split(" ");
//            Arrays.sort(strings);
//            for (int i = 0; i < strings.length; i++) {
//                System.out.print(strings[i] + " ");
//            }
//        }

        String[] strings = sc.nextLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]+"");
        }
    }
}
