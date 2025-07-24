class Solution {
    public String removeDuplicateLetters(String s) {
        // 각 문자의 마지막 등장 위치를 저장
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        // 결과를 저장할 스택 (StringBuilder로 구현)
        StringBuilder result = new StringBuilder();
        // 이미 결과에 포함된 문자들을 추적
        Set<Character> inResult = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 이미 결과에 포함된 문자는 건너뛰기
            if (inResult.contains(c)) {
                continue;
            }
            
            // 현재 문자보다 사전순으로 뒤에 있고, 나중에 다시 나타날 수 있는 문자들을 제거
            while (result.length() > 0 && 
                   result.charAt(result.length() - 1) > c && 
                   lastIndex.get(result.charAt(result.length() - 1)) > i) {
                
                char removed = result.charAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                inResult.remove(removed);
            }
            
            // 현재 문자를 결과에 추가
            result.append(c);
            inResult.add(c);
        }
        
        return result.toString();
    }
}