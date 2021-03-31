package erChaShuCengXu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ErChaShu {
    //层序遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) return;
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            System.out.println(root.val);
            /*=================*/

            if (cur.left != null) {
                q.offer(cur.left);
            }

            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
}
