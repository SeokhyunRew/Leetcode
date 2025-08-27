class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[100];
        int len = nums.length;

        if (nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2]+dp[0];


        for(int i=3; i<nums.length; i++){
            dp[i] = nums[i]+Math.max(dp[i-2], dp[i-3]);
            System.out.println(dp[i]);
        }

        return Math.max(dp[len-1], dp[len-2]);
    }
}