class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]"," ");
        String[] paragraphArr = paragraph.split("\\s+");

        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for(String word : banned) set.add(word.toLowerCase());

        for(String word : paragraphArr) {
            if(!word.isEmpty() && !set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String answer="";

        for(Map.Entry<String, Integer> wordCount : map.entrySet()){
            if(wordCount.getValue()>max){
                max = wordCount.getValue();
                answer = wordCount.getKey();
            }
        }

        return answer;
    }
}