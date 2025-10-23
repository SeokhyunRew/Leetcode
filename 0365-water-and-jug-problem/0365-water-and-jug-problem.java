class Solution {
    boolean answer;
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y==target||x==target||y==target) return true;
        int[] curr = {0, 0};
        int big = Math.max(x, y);
        int small = Math.min(x, y);

        dfs(x, y, target, curr);

        return answer;
    }

    private void dfs(int small, int big, int target, int[] curr){
        curr[1]=big;

        if(curr[0]+curr[1] == target){
            answer=true;
            return;
        }

        curr[1] = big-(small-curr[0]);
        //curr[0] = small;

        curr[0] = curr[1];
        curr[1] = 0;
        
        if(curr[0]+curr[1] == target){
            answer=true;
            return;
        }else if(curr[0]>=small){
            answer=false;
            return;
        }

        dfs(small, big, target, curr);
    }

}