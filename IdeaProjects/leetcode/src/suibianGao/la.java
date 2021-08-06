package suibianGao;

import erChaShuCengXu.TreeNode;

import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class la implements lalala {

    public static void main(String[] args) {

    Stack<Integer>stk = new Stack<>();
        Integer pop = stk.pop();

    }


    public static boolean wordBreak(String s, List<String> wordDict) {
            /*
    *     public static void main(String[] args) {

        ArrayList<String> list =  new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode", list);

    }
    * */
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println(dp[i]+" "+j+" "+i);
                    break;
                }
            }

        }

        return dp[n];
    }

    public static double[] dicesProbability(int n) {
        int[][] dp = new int[n + 2][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {

                for (int cur = 1; cur <= 6 && j >= cur; cur++) {
                    dp[i][j] += dp[i - 1][j - cur];
                }
            }
        }

        double whole = Math.pow(6, n);


        double[] ans = new double[6 * n - n + 1];
        int index = 0;
        for (int i = n; i <= 6 * n; i++) {
            ans[index++] = ((double) dp[n][i]) / whole;
        }

        return ans;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) return ans;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            System.out.println(s);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }


        for (String s : map.keySet()) {
            System.out.println(s);
            ans.add(map.get(s));
        }

        return ans;
    }


    public int strToInt(String str) {

        char[] chars = str.toCharArray();
        int i = 0;
        int signal = 1;
        int ans = 0, bndry = Integer.MAX_VALUE / 10;

        while (chars[i] == ' ') {
            i++;
        }
        if (!isValid(chars[i])) return 0;

        if (chars[i] == '+' || chars[i] == '-') {
            signal = chars[i++] == '+' ? 1 : -1;
        }

        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            if (ans > bndry || ans == bndry && chars[i] > '7')
                return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (chars[i] - '0');
        }


        return signal * ans;


    }

    boolean isValid(char ch) {
        return ch <= '9' || ch >= '0' || ch == '+' || ch == '-';
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][n + 1];
        int max = Integer.MIN_VALUE;
        //第i天买第j天卖的利润
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
            if (prices[i] > prices[i - 1]) {
                for (int j = i + 1; j <= n; j++) {

                    dp[i][j] = Math.max(dp[i][j - 1] + prices[j - 1] - prices[j - 2], dp[i][j - 1]);
                    max = Math.max(max, dp[i][j]);


                }
            }
        }

        return max;

    }

    public int numSquares(int n) {

        int res = Integer.MAX_VALUE;

//        int i = n;
        for (int j = 1; j <= n; j++) {
            int i = j;
            int times = 0;
            int cur = n;
            while (cur > 0) {
                if (cur >= i && Math.pow(i, 0.5) % 1 == 0) {
                    cur -= i;
                    times++;
                } else {
                    i--;
                }
            }

            res = Math.min(res, times);
        }


        return res;
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            ans.add(cur.val);
            if (cur.left != null) que.offer(cur.left);
            if (cur.right != null) que.offer(cur.right);

        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }


        return res;

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int le = 0;
        int ri = 0;
        int res = 0;
//        Set<Character> path = new HashSet<>();
        Map<Character, Integer> path = new HashMap<>();
        while (ri < n) {
            char curChar = s.charAt(ri);

            path.put(curChar, path.getOrDefault(curChar, 0));
            ri++;


            while (path.get(curChar) > 1) {
                path.put(curChar, path.get(curChar) - 1);
                le++;
            }
            res = Math.max(res, path.size());


        }

        return res;

    }

    //0, 1, 3, 5, 6, 7, 19, 28, 37, 45, 67, 76
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len < citations[0]) return len;
        int le = 0, ri = len;
        int res = 0;
        while (le < ri) {
            int mid = le + (ri - le) / 2;
            if (citations[mid] < len - mid) {
                // le = mid+1;
                le = mid + 1;
                res = len - mid - 1;
            } else if (citations[mid] > len - mid) {

                ri = mid;
            } else {
                return citations[mid];
            }


        }

        return res;
    }


}


