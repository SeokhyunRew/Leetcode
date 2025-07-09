class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int current = 0;

        while (current < height.length) {
            // 현재 높이가 이전 스택 top보다 높으면 물이 고일 수 있음
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int bottom = stack.pop(); // 물 바닥 높이

                if (stack.isEmpty()) break;

                int left = stack.peek(); // 왼쪽 벽
                int width = current - left - 1;
                int boundedHeight = Math.min(height[left], height[current]) - height[bottom];
                answer += width * boundedHeight;
            }

            stack.push(current);
            current++;
        }

        return answer;
    }
}
