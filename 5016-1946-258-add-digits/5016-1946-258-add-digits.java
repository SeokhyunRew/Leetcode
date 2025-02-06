class Solution {
    public int addDigits(int num) {

        while (num >= 10) {
            num = reply(num); 
        }
        return num;
        
    }

    public int reply(int num) {
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num = num / 10;
        }
        return temp;
    }
}
