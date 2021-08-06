package Tu.Floyd;

public class Floyd {
    int N = 110, M = 6010;
    int[][] w = new int[N][N];
    int INF = 0x3f3f3f3f;
    int n, k;
    //times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间；标号是1---n
    //输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    //输出：2
    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n; k = _k;
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 邻接矩阵存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
        // Floyd
        floyd();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[k][i]);
        }
        return ans >= INF / 2 ? -1 : ans;
    }
    void floyd() {
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }

//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
