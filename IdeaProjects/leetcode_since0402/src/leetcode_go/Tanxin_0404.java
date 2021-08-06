package leetcode_go;

import java.util.Arrays;
import java.util.Comparator;

public class Tanxin_0404 {


        public int findMinArrowShots(int[][] points) {
            if(points.length==0){
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

            for (int[] point : points) {
                System.out.println(Arrays.toString(point));
            }
            int res = 1;
            int length = points.length;
            int right = points[0][1];
            //先找最小不重叠个数
            for(int i=1;i<points.length;i++){
                if(points[i][0]>right){
                    res++;
                    right = points[i][1];
                }
            }

            return res;
        }

    public static void main(String[] args) {
        Tanxin_0404 tanxin_0404 = new Tanxin_0404();
        int[][]points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(tanxin_0404.findMinArrowShots(points));

    }

}
