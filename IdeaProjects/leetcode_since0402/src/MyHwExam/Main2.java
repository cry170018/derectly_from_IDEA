package MyHwExam;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int num = M;
        while (num > N) {
            num = num / 2;
            count++;
        }
        int n1 = Math.abs(num-N);
        int n2 = Math.abs(num*2-N);
        if(n1>n2){
            count--;
            System.out.println(count+n2+M%2);
        }else{
            System.out.println(count+n1+M%2);
        }
    }
}
