class Solution {
    Map<Integer, Integer> keep = new HashMap<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] arr : edges){
            graph.putIfAbsent(arr[0], new ArrayList<>());
            graph.putIfAbsent(arr[1], new ArrayList<>());

            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        for(int key : graph.keySet()){
            dfs(key, key, -1, 0, graph);
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : keep.entrySet()){
            if(entry.getValue()<min) min = entry.getValue();
        }

        List<Integer> answer = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : keep.entrySet()){
            if(entry.getValue()==min) answer.add(entry.getKey());
        }

        if(n==1) answer.add(0);
        
        return answer;
    }

    private void dfs(int root, int start, int before, int depth, Map<Integer, List<Integer>> graph){
        
        if(graph.get(start).size()==1&&before==graph.get(start).get(0)){
            if(keep.get(root)==null || keep.get(root)<depth) keep.put(root, depth);
            return;
        }

        for(int num : graph.get(start)){
            if(num==before) continue;
            dfs(root, num, start, depth+1, graph);
        }

    }
}