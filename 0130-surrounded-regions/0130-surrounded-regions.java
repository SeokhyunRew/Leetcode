class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int j=0; j<n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X'; 
                } else if(board[i][j] == 'V'){
                    board[i][j] = 'O'; 
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        if(board[x][y] != 'O') return;
        board[x][y] = 'V'; 

        for(int i=0; i<4; i++){
            if(x+dx[i]>=0 &&
               y+dy[i]>=0 &&
               x+dx[i]<board.length &&
               y+dy[i]<board[0].length
            ) dfs(board, x+dx[i], y+dy[i]);
        }
    }
}
