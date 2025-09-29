class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        PriorityQueue<Integer> answer = new PriorityQueue<>();

        dp[0][0] = triangle.get(0).get(0);

        if(triangle.size()==1) return dp[0][0];

        for(int i=1; i<triangle.size(); i++){
            int lastIndex = triangle.get(i).size()-1;
            for(int j=0; j<=lastIndex; j++){
                
                if(j==0) dp[i][j] = dp[i-1][0]+triangle.get(i).get(0);
                else if(j==lastIndex) dp[i][j] = dp[i-1][lastIndex-1]+triangle.get(i).get(lastIndex);
                else dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);

                if(i==triangle.size()-1) answer.offer(dp[i][j]);
            }
        }

        return answer.peek();
    }
}