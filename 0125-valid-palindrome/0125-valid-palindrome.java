class Solution {
    public boolean isPalindrome(String s) {
        char[] c =  s.toLowerCase().toCharArray();
        int len = c.length;
        int left = 0;
        int right = len-1;

        while(left<right){
            if(!Character.isLetterOrDigit(c[left])){
                left++;
                continue;
            }else if(!Character.isLetterOrDigit(c[right])){
                right--;
                continue;
            }

            if(c[left] != c[right]) return false;

            left++;
            right--;
        }

        return true; 
    }
}