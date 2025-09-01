class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n==1) return List.of(0);
        
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] arr:edges){
            map.putIfAbsent(arr[0],new ArrayList<>());
            map.putIfAbsent(arr[1],new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        int size = map.size();
        List<Integer> leafNodes = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {  
                leafNodes.add(entry.getKey());
            }
        }

        while(size>2){
            
            List<Integer> newLeaves = new ArrayList<>();

            size-=leafNodes.size();
            for(int leaf:leafNodes){
                int next = map.get(leaf).get(0);
                map.get(next).remove((Object)leaf);
                if(map.get(next).size() == 1){
                    newLeaves.add(next);
                }
                leafNodes = newLeaves;
            }

            
        }
        return leafNodes;
    }
}