package QianZhuiSum;

import java.util.HashMap;

public class FindSubArraySumK {


    //常规版o(n^2)
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        int ans = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                // sum of nums[j..i-1]
                if (sum[i] - sum[j] == k)
                    ans++;

        return ans;
    }
    //优化版，O(n)
    int subarraySumAdvantage(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int ans = 0,sum0_i = 0;

        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if(preSum.containsKey(sum0_j))
                ans+=preSum.get(sum0_j);

            preSum.put(sum0_i,
                    preSum.getOrDefault(sum0_i,0) + 1);
        }

        return ans;
    }





}
