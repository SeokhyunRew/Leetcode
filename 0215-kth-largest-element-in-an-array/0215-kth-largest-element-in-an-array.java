class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        for(int num : nums) queue.add(num);

        for(int i=0; i<k; i++){
            if(i==k-1) return queue.poll();
            queue.poll();
        }

        return 0;
    }
}