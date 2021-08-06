package leetcode_go;

import CommonClassUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class XuLieHua {



        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            if(root==null){
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while(!que.isEmpty()){
                TreeNode cur = que.poll();
                if(cur==null){
                    sb.append("null").append(",");
                    continue;
                }
                sb.append(String.valueOf(cur.val)).append(",");
                System.out.println(sb.toString());
                que.offer(cur.left);

                que.offer(cur.right);
            }
            System.out.println("while结束");
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");

            return sb.toString();

        }
//        static String serialize(TreeNode root) {
//            if (root == null) return "";
//            StringBuilder sb = new StringBuilder();
//            // 初始化队列，将 root 加入队列
//            Queue<TreeNode> q = new LinkedList<>();
//            q.offer(root);
//
//            while (!q.isEmpty()) {
//                TreeNode cur = q.poll();
//
//                /* 层级遍历代码位置 */
//                if (cur == null) {
//                    sb.append("null").append(",");
//                    continue;
//                }
//                sb.append(cur.val).append(",");
//                /*****************/
//
//                q.offer(cur.left);
//                q.offer(cur.right);
//            }
//            sb.deleteCharAt(sb.length()-1);
//            return sb.toString();
//        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if(data.equals("[]")){
                return null;
            }
            System.out.println("反序列化时接受的String");
            System.out.println(data);
            System.out.println("substring："+data.substring(1,data.length()-1));
            String[] strs=data.substring(1,data.length()-1).split(",");
            System.out.println("分割之后的：");
            for (String str : strs) {
                System.out.print(str);
            }
            System.out.println("============");
            //辅助队列，用来记录进出的顺序
            Queue<TreeNode> que =  new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
            que.offer(root);
            int index = 1;
            while(index<strs.length){

                TreeNode parent = que.poll();

                String left = strs[index++];
                if(!"null".equals(left)){
                    parent.left = new TreeNode(Integer.parseInt(left));
                    que.offer(parent.left);
                } else{
                    parent.left =null;
                }

                String right = strs[index++];
                if(!"null".equals(right)){
                    parent.right = new TreeNode(Integer.parseInt(right));
                    que.offer(parent.right);
                }else{
                    parent.right = null;
                }

            }

            return root;
        }

    public static void main(String[] args) {
        String tree = "[1,2,3,null,null,4,5]";
        TreeNode deserialize = deserialize(tree);
//        System.out.println(deserialize.val);
        String serialize = serialize(deserialize);
        System.out.println("最后序列化的"+serialize);
//        TreeNode deserialize1 = deserialize(serialize);
//        String serialize1 = serialize(deserialize1);
//        System.out.println(serialize1+"这是第二次序列画的");
    }

}
