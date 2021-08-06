package Tu;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Integer, Integer> father;

    //在并查集里，每个节点会记录它的父节点
    public UnionFind() {
        father = new HashMap<Integer, Integer>();
    }

    //    当把一个新节点添加到并查集中，它的父节点应该为自己
    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, x);
        }
    }

    //如果发现两个节点是连通的，那么就要把他们合并，也
    // 就是他们的祖先是相同的。这里究竟把谁当做父节点一般是没有区别的
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            father.put(rootX, rootY);
        }
    }

    //查找祖先的方法是：如果节点的父节点不为空，那就不断迭代
    public int find(int x) {
        int root = x;

        while (father.get(root) != null) {
            root = father.get(root);
        }

        while (x != root) {
            int original_father = father.get(x);
            father.put(x, root);
            x = original_father;
        }

        return root;
    }

    //我们判断两个节点是否处于同一个连通分量的时候，就需要判断它们的祖先是否相同
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

//作者：MiloMusiala
//        链接：https://leetcode-cn.com/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
