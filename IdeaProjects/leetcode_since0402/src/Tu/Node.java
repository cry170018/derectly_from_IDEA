package Tu;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in; //入度：指向我的边数
    public int out;//出度：指出去的边数
    public ArrayList<Node>nexts;//由我直接发散出去的点集合
    public ArrayList<Edge>edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
