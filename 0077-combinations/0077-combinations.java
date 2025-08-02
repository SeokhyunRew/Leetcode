class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int beforeStartIndex = 1;
        int depth = 0;

        dfs(answer, curr, beforeStartIndex, depth, n, k);
        
        return answer;
    }

    private static void dfs(List<List<Integer>> answer, List<Integer> curr, int beforeStartIndex, int depth, int n, int k){

        if(depth>=k){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=beforeStartIndex; i<=n; i++){
            curr.add(i);
            dfs(answer, curr, i+1, depth+1, n, k);
            curr.remove(curr.size()-1);
        }

    }
}