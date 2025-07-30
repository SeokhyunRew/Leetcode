class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> used = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(nums, answer, used, new ArrayList<>());

        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, Set<Integer> used, List<Integer> curr){
        
        if(nums.length == used.size()){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int num : nums){
            if(!used.contains(num)){
                curr.add(num);
                used.add(num);
                dfs(nums, answer, used, curr);
                curr.remove(curr.size()-1);
                used.remove(num);
            }
        }
    }

}