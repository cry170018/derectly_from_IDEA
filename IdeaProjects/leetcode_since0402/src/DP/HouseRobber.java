package DP;

import CommonClassUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * 打家劫舍
 * */
public class HouseRobber {


    /*
     * 1.相邻两间屋子不准都被偷
     * */
    int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        //dp[i]表示：从第i家开始打劫，所得到的最大值
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    /*
     * 1.相邻两间屋子不准都被偷,使用递归dp
     * */
    int robByRecursion(int[] nums) {
        return dp(nums, 0);
    }

    int dp(int[] nums, int start) {
        if (start >= nums.length) return 0;
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        return res;

    }


    /*
     * 2.除1之外，房子不是一排，围成一圈,
     * 所以首尾也是相邻的
     * */
    int robCircleHouseByRecursion(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        return Math.max(dpWithCircle(nums, 0, n - 2), dpWithCircle(nums, 1, n - 1));
    }

    //start end ：抢的整个圈范围
    int dpWithCircle(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        //dp[i]表示：从第i家开始打劫，所得到的最大值
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[start];
    }

    /*
     *
     * 房子不是一排，不是一圈，而是一棵二叉树！
     * 房子在二叉树的节点上，相连的两个房子不能同时被抢劫
     * */
    Map<TreeNode, Integer> memo = new HashMap<>();

    int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int do_it = root.val
                + (root.left == null ?
                0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ?
                0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        int res = houseRobber.rob(nums);
        res = houseRobber.robByRecursion(nums);
        res = houseRobber.robCircleHouseByRecursion(nums);
        System.out.println(res);
    }
}
