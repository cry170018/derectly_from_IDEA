package BFS;

import CommonClassUtils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//bfs模板
public class CengXuBianLi_0411 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> path = new LinkedList<>();
        path.add(root);
        while (!path.isEmpty()) {
            int sizeOfPath = path.size();
            List<Integer> smallList = new LinkedList<>();

            for (int i = 0; i < sizeOfPath; i++) {
                TreeNode node = path.removeFirst();
                smallList.add(node.val);
                if (node.left != null) path.addLast(node.left);
                if (node.right != null) path.addLast(node.right);
            }
            res.add(smallList);
        }

        return res;
    }
}
