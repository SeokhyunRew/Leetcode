class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] copy = Arrays.copyOf(height, len);

        Arrays.sort(copy);

        int maxHeight = copy[len-1];
        int answer = 0;

        for(int i=1; i<=maxHeight; i++){
            int beforeIndex=-1;
            for(int j=0; j<len; j++){
                int currHeight = height[j];
                if(currHeight>=i){
                    if(beforeIndex==-1) beforeIndex=j;
                    else{
                        answer += j-beforeIndex-1;
                        beforeIndex = j;
                    }
                } 
            }
        }

        return answer;
    }
}