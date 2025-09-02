class Solution {
    public int jump(int[] nums) {
        
        int index = 0;
        int answer = 0;

        if(nums.length==1) return 0;

        while(index<nums.length-1){
            answer++;
            int len = nums[index];
            int max = index+1;

            for(int i=index+1; i<=index+len; i++){
                if(i >= nums.length-1) return answer;
                if(nums[i] + i > nums[max] + max) max = i;
            }
            index = max;
        }

        return answer;
    }
}