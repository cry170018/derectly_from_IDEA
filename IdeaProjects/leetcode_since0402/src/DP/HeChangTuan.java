package DP;

import java.util.Scanner;

public class HeChangTuan {
    //做两次递增子串
    void HeChangDui(){
        Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }

            int[] dp1 = new int[num];
            int[] dp2 = new int[num];

            dp1[0] = 1;
            dp2[num - 1] = 1;

            for (int i = 0; i < num; i++) {
                dp1[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                    }
                }
            }

            for (int i = num - 1; i >= 0; i--) {
                dp2[i] = 1;
                for (int j = num - 1; j > i; j--) {
                    if (arr[j] < arr[i]) {
                        dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                    }

                }
            }

            int[] ans = new int[num];
            int max = 0;
            for (int i = 0; i < num; i++) {
                ans[i] = dp1[i]+dp2[i]-1;
                max = Math.max(max,ans[i]);
            }

            System.out.println(num-max);



        }


}
