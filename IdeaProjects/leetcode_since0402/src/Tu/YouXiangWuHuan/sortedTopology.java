package Tu.YouXiangWuHuan;

import Tu.Graph;
import Tu.Node;

import java.util.*;

public class sortedTopology {
    //有向无环图，拓扑排序
    List<Node> sortedTopology(Graph graph) {
        //key：node  value：该点目前剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为0的点的队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) zeroInQueue.add(node);
        }

        List<Node> ans = new ArrayList<>();
        //拓扑排序结果，依次加入ans
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            ans.add(cur);
            //擦去该点的影响，即他的next点的入度减一
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }

        return ans;
    }
}
