package Tu.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //n个点，flights{from,to,edge},K个中转内，即最多K+1步从src到达dst
        int[][] graph = new int[n][n];
        //创建邻接矩阵
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        //根据当前花费的值排序的最小堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{src, 0, K + 1});//起点，当前费用，当前剩余站数限制

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int node = front[0];
            int price = front[1];
            int curK = front[2];

            if (node == dst) return price;

            if (curK > 0) {
                for (int i = 0; i < n; i++) {
                    if (graph[node][i] > 0) {//与当前点连接的其他点还存在
                        minHeap.offer(new int[]{i, price + graph[node][i], curK - 1});
                    }
                }
            }
        }
        return -1;
    }


//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-hang-ban-b-2/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
