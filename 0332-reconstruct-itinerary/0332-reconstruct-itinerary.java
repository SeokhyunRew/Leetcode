class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<tickets.size(); i++){
            List<String> ticket = tickets.get(i);
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!map.containsKey(from)) map.put(from, new ArrayList<>());
            map.get(from).add(to);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }

        dfs("JFK", map, answer);
        
        Collections.reverse(answer);
        return answer;
    }

    private static void dfs(String from, Map<String, List<String>> map, List<String> answer) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            String to = map.get(from).remove(0);
            dfs(to, map, answer);
        }
        answer.add(from);
    }

}