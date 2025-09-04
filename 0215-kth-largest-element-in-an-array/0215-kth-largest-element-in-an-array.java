class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int num : nums) minHeap.offer(num);
        int index = 0;
        while(index < k-1){
            index++;
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}