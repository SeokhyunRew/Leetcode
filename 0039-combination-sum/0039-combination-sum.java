class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(answer, curr, 0, candidates, target);

        return answer;
    }

    private static void dfs(List<List<Integer>> answer, List<Integer> curr, int beforeIndex, int[] candidates, int target){
        
        if(target==0){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=beforeIndex; i<candidates.length; i++){
            int currNum = candidates[i];
            if(currNum>target) return;
            curr.add(currNum);
            dfs(answer, curr, i, candidates, target-currNum);
            curr.remove(curr.size()-1);
        }
    }
}