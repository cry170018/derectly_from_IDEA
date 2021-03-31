package day0315_jianzhi29;

import java.util.LinkedList;
import java.util.List;

class Solution {


    public List<Integer> spiralOrder(int[][] matrix) {

        int runNum=0;
        List<Integer> list = new LinkedList<>();
        int kuan=matrix.length;
        int chang=matrix[0].length;
        int top=0,bottom=kuan-1,left=0,right=chang-1;
        int elemNum = kuan*chang;
        while(left<=right&&top<=bottom&&elemNum>0){
            runNum++;

            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
                elemNum--;
            }
            for(int i=top+1;i<=bottom;i++){
                list.add(matrix[i][right]);
                elemNum--;

            }
            if(left < right && top < bottom){
                for(int i=right-1;i>=left;i--){
                    list.add(matrix[bottom][i]);
                    elemNum--;

                }
                for(int i=bottom-1;i>=top+1;i--){
                    list.add(matrix[i][left]);
                    elemNum--;

                }
            }


            top++;
            bottom--;
            left++;
            right--;

        }
        for (Integer integer : list) {

        }        return list;

    }

    public static void main(String[] args) {
        int[][]matrix= {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        Solution solution = new Solution();
        List<Integer> integers = solution.spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }
}
