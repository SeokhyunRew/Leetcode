class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return answer;
        }

        List<Integer> list = Arrays.stream(nums)
            .boxed()  
            .collect(Collectors.toList());

        dfs(answer,nums,list,new ArrayList<>());

        return answer;
    }

    private void dfs(List<List<Integer>> answer, int[] nums, List<Integer> toAdd,
    List<Integer> added){

        if(toAdd.isEmpty()){
            answer.add(new ArrayList<>(added));
            return;
        }

        for(Integer i:toAdd){
            List nextToAdd = new ArrayList<>(toAdd);
            nextToAdd.remove(i);
            added.add(i);
            dfs(answer,nums,nextToAdd,added);
            added.remove(i);
        }
    
    }
}
