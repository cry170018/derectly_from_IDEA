package DP;

import java.util.*;

public class ChildrenArray {

    /*
    * 如abxabyb中，bb就是其子串，回文，所以bb是，他不是一定要连着的，所以可以遍历，只要是有相同的，子串长度就可以+2
    * */
    //最长回文子序列
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];//dp[i][j]表示i到j的子序列中最长回文子序列长度
        //左下半角全为0，对角线为1:i>j时，没有子序列，i=j时，子序列为本身

        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];

    }
    //最长回文子序列
    //一维数组法
    public  int longestPalindromeSubseq_SingleDim(String s) {
        int n = s.length();
        int[] dp = new int[n];
      //  dp[n-1] = 1;
        for(int i=n-1;i>=0;i--) {
            dp[i] = 1;
            int pre = 0;
            for(int j=i+1;j<n;j++){
                int temp = dp[j];
                if(s.charAt(i)==s.charAt(j)){
                    dp[j] = pre+2;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                //在当前位被进行下一位计算覆盖前记住，
                pre = temp;

            }
/*
            System.out.println(Arrays.toString(dp));
*/
        }

            return dp[n-1];

    }

    public static void main(String[] args) {
        String s = "cbbd";
        ChildrenArray childrenArray = new ChildrenArray();
        int i = childrenArray.longestPalindromeSubseq_SingleDim(s);
        System.out.println(i);
    }



}
