class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        char[] ch_array = String.valueOf(x).toCharArray();

        for(int i=0; i<ch_array.length; i++){
            if(ch_array[i] != ch_array[ch_array.length-1-i]) return false;
        }   

        return true;
    }
}