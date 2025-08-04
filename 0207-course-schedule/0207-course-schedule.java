class Solution {
    boolean answer=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapRoute = new HashMap<>();
        Set<Integer> isUsed = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<prerequisites.length; i++){
            mapRoute.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            mapRoute.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        if(prerequisites.length<=1) return true;

        for(int start : mapRoute.keySet()){
            isUsed.add(start);
            dfs(start, mapRoute, isUsed, visited);
            isUsed.remove(start);
        }

        return answer;
    }

    private void dfs(int start, Map<Integer, List<Integer>> mapRoute, Set<Integer> isUsed, Set<Integer> visited){

        if(!mapRoute.containsKey(start)){
            visited.add(start);
            return;
        }
        if(visited.contains(start)) return;

        List<Integer> canGo = mapRoute.get(start);

        for(int num : canGo){
            if(isUsed.contains(num)){
                answer=false;
                return;
            }
            isUsed.add(num);
            dfs(num, mapRoute, isUsed, visited);
            isUsed.remove(num);
        }
        
        visited.add(start);
    }

}