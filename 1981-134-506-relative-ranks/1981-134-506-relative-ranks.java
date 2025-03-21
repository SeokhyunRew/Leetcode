class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] s = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] answer = new String[score.length];
        HashMap<Integer, String> map = new HashMap<>();
        int[] copy_array = Arrays.copyOf(score, score.length);

        Arrays.sort(copy_array);

        for(int i=copy_array.length-1; i>=0; i--){
            if(i>copy_array.length-4){
                map.put(copy_array[i], s[copy_array.length-i-1]);
                continue;
            }
            map.put(copy_array[i], String.valueOf(copy_array.length-i));
        }

        for(int i=0; i<score.length; i++){
            answer[i] = map.get(score[i]);
        }   

        return answer;
        
    }
}