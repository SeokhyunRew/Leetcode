/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while(l1 != null || l2 != null){
            if(l1!=null){
	            num1.insert(0, l1.val);
              l1 = l1.next;
            }

            if(l2!=null){
	            num2.insert(0, l2.val);
              l2 = l2.next;
            }
        }

        BigInteger sumNumber = new BigInteger(num1.toString()).add(new BigInteger(num2.toString()));

        String sumStr = String.valueOf(sumNumber);
        ListNode answer = null;

        for (int i = 0; i < sumStr.length(); i++) {
            int digit = sumStr.charAt(i) - '0'; 
            answer = new ListNode(digit, answer); 
        }

        return answer;
        
    }
}
