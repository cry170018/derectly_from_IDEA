package Tu.Prim;

import Tu.Edge;
import Tu.Graph;
import Tu.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
//随便找个点开始求最小生成树，十分像层序遍历
    public static Set<Edge> PrimMST(Graph graph) {

        Set<Node> set = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
              return   o1.weight-o2.weight;
            }
        });
        Set<Edge> res = new HashSet<>();
        for (Node node : graph.nodes.values()) {//是为了防止图中点不全部联通的（森林）

            if (!set.contains(node)) {//随便挑一个node做开始点
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);//解锁所有相连的边
                }

                //前期工作完成，开始
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();//弹出最小的边
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {//如果该边的to点没有来过，就把该边加入，该点也加入
                        set.add(toNode);
                        res.add(edge);
                        for (Edge nextEdge : toNode.edges) {//把该点解锁的所有边加入小根堆
                            priorityQueue.add(nextEdge);
                        }
                    }
                }




            }


        }
        return  res;
    }
}
