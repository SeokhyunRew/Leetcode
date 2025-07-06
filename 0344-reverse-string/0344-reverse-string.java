class Solution {
    public void reverseString(char[] s) {
        char beforeChar;
        int len = s.length;

        for(int i=0; i<len/2; i++){
            beforeChar = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = beforeChar;
        }
    }
}