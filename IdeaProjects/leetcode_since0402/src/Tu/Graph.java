package Tu;


import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes;//城市编号，对应的点
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
