class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        if (digits == null || digits.length() == 0) return answer;

        makeDictionary(map);
        dfs(new StringBuilder(), digits, 0, answer, map);

        return answer;
    }

    private void dfs(StringBuilder sb, String digits, int index, List<String> answer, Map<Character, String> map) {
        if (index == digits.length()) {
            answer.add(sb.toString());
            return;
        }

        char currDigit = digits.charAt(index);
        String letters = map.get(currDigit);

        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(sb, digits, index + 1, answer, map);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }

    private void makeDictionary(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
