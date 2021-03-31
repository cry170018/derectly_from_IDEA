package day0310_jianzhi04;

import java.util.HashSet;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0 ) return false;
        int i=0,j=matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(target>matrix[i][j]) i++;
            else if(target<matrix[i][j]) j--;
            else if(target==matrix[i][j]) {
                System.out.println(i+"---"+j);
                return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] inta = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        Solution solution  = new Solution();
        boolean numberIn2DArray = solution.findNumberIn2DArray(inta,17);
        System.out.println(numberIn2DArray);
        HashSet<Integer> set = new HashSet<Integer>();
    }
}
