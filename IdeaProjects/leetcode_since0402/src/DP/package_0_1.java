package DP;

import java.util.Arrays;

public class package_0_1 {


    /*
     * 01背包问题
     * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
     * 其中第i个物品的重量为wt[i]，价值为val[i]，
     * 现在让你用这个背包装物品，最多能装的价值是多少？
     * */
    int packaging(int N,int W,int[] wt,int[] val){
        int [][] dp = new int[N+1][W+1];//前i个物品，放入容量为j的背包，最大可以实现的价值

        for (int i = 1;i<=N;i++){
            for(int j = 1;j<=W;j++){
                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];//容量不够了，只能不放当前物品
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);//wt[i-1]和val[i-1]就是第i个数
                    //不放和放比较，取大的;
                    //放：N-1个物品，W减去当前物品重量的容量---此情况下的最大值+放了当前物品的值=dp[i][j]
                }
            }
        }
        return dp[N][W];
    }
/*
*
* 一维数组,未优化
* */
    int packaging_oneDim (int N,int W,int[] wt,int[] val){
        int dp[] = new int[1+W];
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >=1; j--) {
                if(j<wt[i-1]){
                    dp[j] = dp[j];
                }else {
                    dp[j] = Math.max(dp[j],dp[j-wt[i-1]]+val[i-1]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int packaging = new package_0_1().packaging_oneDim(3,4,new int[]{2, 1, 3},new int[] {4, 2, 3});
        System.out.println(packaging);
    }
}
