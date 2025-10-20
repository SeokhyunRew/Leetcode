class Solution {
    public int trap(int[] height) {
        // 물의 높이는 좌우 기준점 중 낮은 것을 기준으로 쌓인다 -> 높은 방향을 향해서 다가가며 더해 나가자
        int answer = 0;
        int left =0;
        int leftMax = height[left];
        int right = height.length-1;
        int rightMax =height[right];

        // 투 포인터는 if else로 한 번에 한 개의 포인터만 움직이도록..
        while(left<right){
            // 현재 왼쪽 포인터가 더 높은 기둥이라면 오른쪽에서 가야함. 같으면 누가 가도 ㄴㅅㄱ
            if(leftMax >= rightMax){
                //파인 곳 (물을 담을 수 있는 곳을 만난 경우)
                if(height[right-1]<rightMax){
                    //파인 만큼 물을 더함 왼쪽 기둥 생각 x 높은 곳을 향해 가고 있으니 ㄱㅊ
                    answer += rightMax-height[right-1];
                } else{
                    //같거나 더 높은 경우 물이 담기지는 않고 그냥 최대 높이 갱신만 하자.
                    rightMax = height[right-1];
                }
                // 어떤 상황이든 포인터는 갱신한다
                right --;
            } else{
                //위의 경우와 비슷함, 왼쪽이 움직여야 하는 경우
                if(height[left+1]<leftMax){
                    answer += leftMax-height[left+1];
                } else{
                    leftMax = height[left+1];
                }
                left++;
            }
        }   
        return answer;
    }
}