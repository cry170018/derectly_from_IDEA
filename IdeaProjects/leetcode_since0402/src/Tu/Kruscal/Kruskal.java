package Tu.Kruscal;

import Tu.Edge;
import Tu.Graph;
import Tu.Node;
import Tu.UnionFind;

import java.lang.reflect.Array;
import java.util.*;

//得到最小生成树----每个点都联通，且总权值最小
public class Kruskal {
    Set<Edge> kruskal(Graph graph) {
        //模拟并查集,此set代表的<k,v>表示该点相连通的点的集合
        MySet mySet = new MySet((ArrayList) graph.nodes.values());

        //根据边长升序排序队列
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        PriorityQueue<Edge> qqq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return 0;
            }
        });
        Set<Edge> res = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            //看这个边的两点是不是已经联通了，包括直接和间接都算联通
            //如果没有联通，则把这个边加进来，即让这两个点联通,
            //联通后将其union，就是把这两个点原来所属的set相连
            //把此边加入结果集

            if (!mySet.isSameSet(edge.from, edge.to)) {
                res.add(edge);
                mySet.union(edge.from, edge.to);
            }
        }

        //得到最小生成树

        return res;
    }

    //模拟并查集
    class MySet {
        //与该点已经相连的其他点的集合，包括间接相连
        public HashMap<Node, List<Node>> setMap;

        public MySet(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);//先把自己加自己的set中来
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;

        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
        }
    }
}
