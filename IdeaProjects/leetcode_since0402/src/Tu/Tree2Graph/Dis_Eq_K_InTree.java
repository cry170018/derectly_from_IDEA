package Tu.Tree2Graph;

import CommonClassUtils.TreeNode;
import Tu.Node;

import java.util.*;

public class Dis_Eq_K_InTree {

    Map<TreeNode, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(root.val);
            return ans;
        }
        findParent(root);
        int curStep = 0;
        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(target);
        visited.add(target);
        while (!que.isEmpty() && curStep <= k) {
            curStep++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                List<TreeNode> toList = new ArrayList<>();
                toList.add(cur.left);
                toList.add(cur.right);
                if (parents.containsKey(cur))
                    toList.add(parents.get(cur));

                for (TreeNode tn : toList) {
                    if (tn != null) {
                        if (curStep == k) {
                            ans.add(tn.val);
                        } else {
                            que.offer(tn);
                            visited.add(tn);
                        }
                    }

                }
            }

        }

        return ans;


    }
    //记录父节点，这样每个点的所有相邻点都有记录了，变成了图
    void findParent(TreeNode cur) {
        if (cur == null) return;
        if (cur.left != null) {
            parents.put(cur.left, cur);
            findParent(cur.left);
        }
        if (cur.right != null) {
            parents.put(cur.right, cur);
            findParent(cur.right);
        }
    }
}
