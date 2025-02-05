class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int targetNum;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        
        for(int i=0; i<nums.length; i++){
            targetNum = target - nums[i];
            if(map.containsKey(targetNum) && map.get(targetNum)!=i){
                answer[0] = i;
                answer[1] = map.get(targetNum);
            }
        }
        
        return answer;
    }
}