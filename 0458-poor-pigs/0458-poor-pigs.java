class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int T = minutesToTest / minutesToDie; // 테스트 가능한 횟수
        int base = T + 1; // 한 마리가 표현할 수 있는 경우의 수
        int pigs = 0;
        int cases = 1;    // (base^pigs) 경우의 수
        
        while (cases < buckets) {
            pigs++;
            cases *= base;
        }
        return pigs;
    }
}