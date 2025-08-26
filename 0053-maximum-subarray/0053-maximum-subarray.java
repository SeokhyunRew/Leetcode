class Solution {
    public int maxSubArray(int[] nums) {
        
        int answer = Integer.MIN_VALUE;
        int curr = 0;

        for(int num : nums){
            curr += num;
            if(num > curr) curr = num;
            if(curr > answer) answer = curr;
        }

        return answer;
    }
}