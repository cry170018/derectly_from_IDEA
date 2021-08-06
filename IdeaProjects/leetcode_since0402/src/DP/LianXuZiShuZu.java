package DP;

public class LianXuZiShuZu {

/*
* 剑指42
* */
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            // if(len==1)return nums[];
            int[] dp = new int[len+1];//以nums[i]为结尾的子数组的和的最大值
            dp[0] = nums[0];
            int res = dp[0];
            for(int i=1;i<len;i++){
                dp[i] = Math.max(0,dp[i-1])+nums[i];
                res = Math.max(res,dp[i]);
            }

            return res;
        }

}
