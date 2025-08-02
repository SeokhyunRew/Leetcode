class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int i=0; i<=nums.length; i++) dfs(answer, curr, nums, i, 0, 0);

        return answer;
    }

    private static void dfs(List<List<Integer>> answer, List<Integer> curr, int[] nums, int targetNum, int depth, int beforeIndex){
        if(depth==targetNum){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=beforeIndex; i<nums.length; i++){
            int currNum = nums[i];
            curr.add(currNum);
            dfs(answer, curr, nums, targetNum, depth+1, i+1);
            curr.remove(curr.size()-1);
        }
    }
}