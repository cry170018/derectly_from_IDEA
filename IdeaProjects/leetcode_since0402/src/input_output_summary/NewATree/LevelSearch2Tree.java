package input_output_summary.NewATree;

import CommonClassUtils.TreeNode;

import java.util.LinkedList;
import java.util.Scanner;

public class LevelSearch2Tree {

    //1431#2#####1###
    public TreeNode creatTreeNode(String dataString) {
        if (dataString.length() <= 0) {
            return null;
        }
        TreeNode[] NodeArray = new TreeNode[dataString.length()];

        for (int i = 0; i <= dataString.length() - 1; i++) {
            if (dataString.charAt(i) != '#') {
                // 这里是个坑，如果不判断就 new, 导致子节点重新创建，爷孙关系就断了, A -->B, C---->D, C
                // 是重新创建的节点
                if (NodeArray[i] == null) {
                    NodeArray[i] = new TreeNode(
                            (int) (dataString.charAt(i) - '0'));
                }

                int idx = 2 * i + 1;
                if (idx <= dataString.length() - 1
                        && dataString.charAt(idx) != '#') {
                    NodeArray[idx] = new TreeNode(
                            (int) (dataString.charAt(idx) - '0'));
                    NodeArray[i].left = NodeArray[idx];
                } else {
                    NodeArray[i].left = null;
                }

                idx++;
                if (idx <= dataString.length() - 1
                        && dataString.charAt(idx) != '#') {
                    NodeArray[idx] = new TreeNode(
                            (int) (dataString.charAt(idx) - '0'));
                    NodeArray[i].right = NodeArray[idx];
                } else {
                    NodeArray[i].right = null;
                }
            }
        }
        return NodeArray[0];
    }


    public static void main(String[] args) {
        LevelSearch2Tree l2t = new LevelSearch2Tree();
        //"1,4,3,1,#,2,#,#,#,#,#,1,#,#,#"
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode treeNode = l2t.creatTreeNode(s);
        l2t.zhongxuSearch(treeNode);
    }

    void zhongxuSearch(TreeNode root) {
        if (root == null) {
//            System.out.print("null" + " ");
            return;
        }

        zhongxuSearch(root.left);
        System.out.print(root.val+ " ");
        zhongxuSearch(root.right);
    }


}
