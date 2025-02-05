class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();

        for(char c : String.valueOf(x).toCharArray()){
            sb.append(c);
        }

        return (sb.toString().equals(sb.reverse().toString()))?true:false;
    }
}