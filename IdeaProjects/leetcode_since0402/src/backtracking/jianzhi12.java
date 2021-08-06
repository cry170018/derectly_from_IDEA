package backtracking;
/*
* 本题不一样在，在主函数里做两层for循环处理不同的起始点，然后进入dfs
* 进入后，回溯的方式不是循环，而是该点的上下左右四个点，
* */
public class jianzhi12 {


        int m,n;
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            if(m==1&&n==1&&word.length()>1)return false;
            int[][] isUsed = new  int[m][n];

            for(int i=0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(dfs(board,isUsed,word,i,j,0))return true;
                }
            }
            return false;
        }

        boolean dfs(char[][] board,int[][] isUsed, String word,int row,int col,int curIndex){
            if(row>=m||col>=n||row<0||col<0||
                    board[row][col]!=word.charAt(curIndex)||
                    isUsed[row][col]==1){
                return false;
            }
            if(curIndex==word.length()-1){
                return true;
            }

            isUsed[row][col] = 1;//选择
            boolean ans = dfs(board,isUsed,word,row+1,col,curIndex+1)
                    ||dfs(board,isUsed,word,row-1,col,curIndex+1)
                    ||dfs(board,isUsed,word,row,col+1,curIndex+1)
                    ||dfs(board,isUsed,word,row,col-1,curIndex+1);

            isUsed[row][col] = 0;//回溯
            return ans;
        }

}
