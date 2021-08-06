package DP;

import java.util.Arrays;

public class StoneGame {
    /*
    * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。

石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。比如有三堆石头 piles = [1,100,3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。

假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。
  *
  *博弈问题
  * 海盗粉宝石，两人分硬币同理
  * */



    int stoneGame(int[] piles) {
        int n = piles.length;

        Pair[][] dp = new Pair[n][n];
        //填充
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], new Pair(0, 0));
        }
        //对角线baseCase
        for (int i = 0; i < n; i++) {
            dp[i][i] = new Pair(piles[i], 0);

        }
//        for (int i = 0; i < n; i++) {
//            for (int i1 = 0; i1 < n; i1++) {
//                System.out.print("("+dp[i][i1].fir+","+dp[i][i1].sec+")");
//            }
//            System.out.println();
//        }

        //拉不拉东在这里用的斜遍历，我用的从下至上，从左到右
        /*
        i:这一排石头堆的最左一堆j:这一排石头堆的最右一堆
        pair:fir表示当前我是先手的情况，sec表示我是后手
        */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //先手选择最左边或者最右边
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;

                if (left > right) {
                    //两种选择：当前我是先手，就选左，我市后手，对手肯定选了左，我只能作为后手选右
                    dp[i][j] = new Pair(left,dp[i+1][j].sec);
                } else {
                    dp[i][j] = new Pair(right,dp[i][j - 1].fir);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                System.out.print("(" + dp[i][i1].fir + "," + dp[i][i1].sec + ")");
            }
            System.out.println();
        }
        return dp[0][n - 1].fir - dp[0][n - 1].sec;


    }

    public static void main(String[] args) {
        int[] piles = new int[]{3, 9, 1, 2};
        StoneGame stoneGame = new StoneGame();
        System.out.println(stoneGame.stoneGame(piles));
    }
}





class Pair {
    int fir, sec;

    Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }

}
