class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int curr = 0;
        int index = 0;

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, index);
                curr++;
                answer = (answer<curr)?curr:answer;
            }else curr = reOrderMap(map, c, index);

            index++;
        }

        return answer;
    }

    private int reOrderMap(Map<Character, Integer> map, char c, int index){
        int cIndex = map.get(c);
        map.entrySet().removeIf(entry -> entry.getValue() <= cIndex);
        map.put(c, index);

        return map.size();
    }
}