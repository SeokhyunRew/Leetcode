class Solution {
    public int arrayPairSum(int[] nums) {
        nums = countingSort(nums);
        int answer = 0;

        for (int i = 0; i < nums.length; i += 2) answer += nums[i];

        return answer;
    }

    private int[] countingSort(int[] nums) {
        int offset = 10000; 
        int[] countArr = new int[20001]; 
        int[] returnArr = new int[nums.length];
        int index = 0;

        for (int num : nums) countArr[num + offset]++;

        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                returnArr[index++] = i - offset; 
                countArr[i]--;
            }
        }

        return returnArr;
    }
}
