class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[!?',;.]"," ");
        
        for(int i=0; i<banned.length; i++) paragraph = paragraph.replaceAll(banned[i].toLowerCase(), "");
        
        String[] paragraphArr = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<paragraphArr.length; i++) {
            String currWord = paragraphArr[i];
           if(!currWord.isEmpty()) map.put(currWord, map.getOrDefault(currWord, 0)+1);
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