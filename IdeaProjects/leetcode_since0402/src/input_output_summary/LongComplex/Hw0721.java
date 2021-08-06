package input_output_summary.LongComplex;

import java.util.*;


//floyd最长路径
public class Hw0721 {
   static int row;
   static int col,path;
    public static void main(String[] args) {
        //输入：[[1,2,5],[1,3,5],[2,3,10]] // 非原数据
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
        String sub = s.substring(2, s.length() - 2);
        System.out.println(sub);
        String[] split = sub.split("\\],\\[");
        int[][] adj = new int[split.length][3];
        Set<Integer> dumpSet = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(",");
            adj[i][0] = Integer.valueOf(split1[0]);
            dumpSet.add(adj[i][0]);
            adj[i][1] = Integer.valueOf(split1[1]);
            dumpSet.add(adj[i][1]);
            adj[i][2] = Integer.valueOf(split1[2]);
        }
        //Check
        for (int[] ints : adj) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        int pointNum = dumpSet.size();
        int[][] table = new int[pointNum + 1][pointNum + 1];
        for (int[] ints : table) {
            Arrays.fill(ints,-1);
        }
        for (int i = 0; i < pointNum; i++) {
            int from = adj[i][0],to = adj[i][1],edge = adj[i][2];
            table[from][to] = edge;
        }

        int max = floyd(table, pointNum);
        System.out.println(max);
        System.out.println(row);
        System.out.println(col);
        System.out.println(path);


    }

    private static int floyd(int[][] table, int pointNum) {
        int max = 0;
        for(int k = 1;k<=pointNum;k++){
            for(int i = 1;i<=pointNum;i++){
                for(int j = 1;j<=pointNum;j++){
                    if(table[i][j]!=-1&&table[i][k]!=-1&&table[k][j]!=-1){
                        table[i][j] = Math.max(table[i][j],table[i][k]+table[k][j]);
                        if(table[i][j] >max){
                            max = table[i][j];
                            row = i;
                            path = k;
                            col = j;
                        }

                    }

                }
            }
        }

        return max;
    }
}
