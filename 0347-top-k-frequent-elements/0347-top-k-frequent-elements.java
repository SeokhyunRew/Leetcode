class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[k];
        int index = 0;

        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) arr.add(entry.getValue());

        Collections.sort(arr);

        for(int i=arr.size()-1; i>=arr.size()-k; i--) set.add(arr.get(i));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(set.contains(entry.getValue())){
                answer[index] = entry.getKey();
                index++;
            }
        }

        return answer;
    }
}