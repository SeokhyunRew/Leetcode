class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> answer = new HashMap<>();
        

        for(int i=0; i<times.length; i++){
            int from = times[i][0];
            int to = times[i][1];
            int time = times[i][2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[] {to,time});
        }

        for(int i=1; i<=n; i++) answer.put(i, Integer.MAX_VALUE);
        answer.put(k, 0);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(k);

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            
            List<int[]> canGo;
            if(graph.containsKey(currNode)) canGo = graph.get(currNode);
            else continue;

            for(int[] arr : canGo){
                int to = arr[0];
                int time = arr[1];
                if(answer.get(to) > answer.get(currNode)+time){
                    answer.put(to, answer.get(currNode) + time);
                    queue.offer(to);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : answer.entrySet()){
            int value = entry.getValue();
            if(value == Integer.MAX_VALUE) return -1;
            max = (max < value)?value:max;
        }

        return max;
    }
}