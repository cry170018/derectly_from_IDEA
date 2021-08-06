package DP;

import java.util.Arrays;

public class package01_exactly {

    /*
     * 01背包问题
     * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
     * 其中第i个物品的重量为wt[i]，价值为val[i]，
     * 现在让你用这个背包装物品，
     *
     * 恰好装满,即重量刚好等于容量
     *
     * 最多能装的价值是多少？
     * */
    int packaging_oneDim_exactly (int N,int W,int[] wt,int[] val){
        int dp[] = new int[1+W];
        //和普通01背包的区别就在这里
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >=1; j--) {
                if(j<wt[i-1]){
                    dp[j] = dp[j];
                }else {
                    dp[j] = Math.max(dp[j],dp[j-wt[i-1]]+val[i-1]);
                }
            }
        }
        return dp[W]<0?-1:dp[W];
    }

}
