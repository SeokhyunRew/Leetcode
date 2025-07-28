class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int origin = stones.length();
        
        for(char c : jewels.toCharArray())  stones = stones.replaceAll(String.valueOf(c), "");
        
        return origin-stones.length();
    }
}