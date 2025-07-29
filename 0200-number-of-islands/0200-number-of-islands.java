class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(int x, int y, char[][] grid){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        grid[x][y] = '0';

        for(int i=0; i<4; i++){
            if(x+dx[i] >= 0 &&
               x+dx[i] < grid.length &&
               y+dy[i] >= 0 &&
               y+dy[i] < grid[0].length &&
               grid[x+dx[i]][y+dy[i]] == '1')
               {
                    dfs(x+dx[i], y+dy[i], grid);
               }
        }
    }
}