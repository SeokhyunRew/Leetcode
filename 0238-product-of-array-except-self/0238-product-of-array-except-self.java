class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int len = nums.length;
        int zeroCount = 0;
        int zeroIndex = 0;

        for(int i=0; i<len; i++){
            int curr = nums[i];
            if(curr==0){
                zeroCount++;
                zeroIndex = i;
            }
            else total *= curr;
        }
        
        int[] answer = new int[len];

        if(zeroCount >= 2) return answer;

        for(int i=0; i<len; i++){
            if(zeroCount > 0){
                if(i!=zeroIndex) answer[i] = 0;
                else answer[i] = total;
            }else answer[i] = total/nums[i];
        }

        return answer;
    }
}