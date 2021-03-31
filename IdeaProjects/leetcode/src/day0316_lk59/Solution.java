package day0316_lk59;

import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;

class Solution {
    public int[][] generateMatrix(int n) {
        //if(n==0)  return new int[][]={1};
        int n2 = n*n;
        int num= 1;
        int[][] matrix = new int[n][n];
        int top = 0,bottom = n-1,left=0,right=n-1;
        while(num<=n2){
            for(int colum=left;colum<=right;colum++){
                matrix[top][colum] = num++;
            }
            for(int row=top+1;row<=bottom;row++){
                matrix[row][right] = num++;
            }
            for(int colum=right-1;colum>left;colum--){
                matrix[bottom][colum] = num++;
            }
            for(int row=bottom;row>top;row--){
                matrix[row][left] = num++;
            }
            top++;
            bottom--;
            left++;
            right--;

        }
        return matrix;


    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] ints = solution.generateMatrix(1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
