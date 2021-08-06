package Tu;

public class Union {
    // 树的个数
    private int treeCount;
    // 每个树的节点数
    private int[] treeSize;
    // 每个树的根节点
    private int[] treeRoot;

    public Union(int count) {
        // 总共有count棵树
        treeCount = count;

        treeRoot = new int[count];
        treeSize = new int[count];

        for (int i = 0; i < count; i++) {
            // 每棵树只有1个节点
            treeSize[i] = 1;

            // 初始点，每个点的根节点都是自己
            treeRoot[i] = i;
        }
    }

    //查找树的根节点
    public int findRoot(int j) {
        while (treeRoot[j] != j) {
            // 这句是为了压缩路径，不要的话可以跑的通，但效率变低
            //treeRoot[j] = treeRoot[treeRoot[j]];

            j = treeRoot[j];
        }

        return j;
    }

    //判断两点是否存在连接
    public boolean isConnected(int i, int j) {
        int x = findRoot(i);
        int y = findRoot(j);

        //根节点一致，说明两点已经存在连接
        return x == y;
    }

    public void setConnected(int i, int j) {
        int x = findRoot(i);// i的根节点
        int y = findRoot(j);// j的根节点

        if (x != y) {
            if (treeSize[x] > treeSize[y]) {// x树更大，把y接上去
                treeRoot[y] = x;
                treeSize[y] += treeSize[x];
            } else {// y树更大，把x接上去
                treeRoot[x] = y;
                treeSize[x] += treeSize[y];
            }

            treeCount--;
        }
    }

}
//————————————————
//        版权声明：本文为CSDN博主「王小二(海阔天空)」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/qq_29229567/article/details/115922000
