package MyHwExam;

import java.util.*;

public class Main3 {

    static int baudry;
    static ArrayList<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sub = s.substring(1, s.length() - 1);
        String[] numStrs = sub.split(",");
        int len = numStrs.length;
        baudry = len - 1;
//        System.out.println(-1);
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                List<String> cur = new ArrayList<>();
                dfs(numStrs, i, j, cur);
            }
        }
        System.out.println(-1);
        int max = 0;
        int idx = 0 ;
        for (int i = 0; i < ans.size(); i++) {
            if(max<ans.get(i).size()){
                max = ans.get(i).size();
                idx = i;
            }
        }
//        System.out.print("[");

        System.out.println(ans.get(idx));
    }

    static void dfs(String[] strs, int i, int j, List<String> cur) {

        if (i > baudry && j > baudry) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (strs[i] != strs[j]) {
            return;
        }
        else {
            cur.add(strs[i]);
        }
         dfs(strs, 2 * i + 1, 2 * j + 1, cur);
         dfs(strs, 2 * i + 2, 2 * j + 2, cur);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
