class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] s = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] answer = new String[score.length];
        HashMap<Integer, String> map = new HashMap<>();
        int[] copy_array = Arrays.copyOf(score, score.length);

        Arrays.sort(copy_array);

        for (int i = 0; i < copy_array.length / 2; i++) {
            int temp = copy_array[i];
            copy_array[i] = copy_array[copy_array.length - 1 - i];
            copy_array[copy_array.length - 1 - i] = temp;
        }

        for(int i=0; i<copy_array.length; i++){
            if(i<3){
                map.put(copy_array[i], s[i]);
                continue;
            }
            map.put(copy_array[i], String.valueOf(i+1));
        }

        for(int i=0; i<score.length; i++){
            answer[i] = map.get(score[i]);
        }   

        return answer;
        
    }
}