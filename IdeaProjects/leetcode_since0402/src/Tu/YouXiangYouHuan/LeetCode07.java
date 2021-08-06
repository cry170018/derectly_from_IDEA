package Tu.YouXiangYouHuan;

import java.util.ArrayList;
import java.util.List;
//有向有环
public class LeetCode07 {
/*
* 在有向图中，找到从0点到n-1点，的所有需要step步到达的，路径数
* */
    int way, n, k;
    List<List<Integer>> edges;
    public static void main(String[] args) {
        int n = 5;
        int[][] relation = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int k = 3;
        LeetCode07 lc = new LeetCode07();
        System.out.println(lc.numWays(n, relation, k));
    }
    

    public int numWays(int n, int[][] relation, int k) {
        way = 0;
        this.n = n;
        this.k = k;

        /*===========================套路=================*/
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        System.out.println(edges);

        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);

        }
        /*==================================================*/
        //edges:索引代表点，索引的list代表该点可到达的点
        System.out.println(edges);
        dfs(0, 0);
        return way;
    }

    void dfs(int index,int step){
        if(step==k){
            if(index==n-1){
                way++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for(int nextIndex:list){
            dfs(nextIndex,step+1);
        }
    }


}
