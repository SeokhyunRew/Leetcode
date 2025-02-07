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
        ListNode dummy = new ListNode(0);
        ListNode answer = dummy;

        StringBuilder sb = new StringBuilder();
        int temp = 0;

        while (l1 != null || l2 != null) {
            int l1_num = (l1 != null) ? l1.val : 0;
            int l2_num = (l2 != null) ? l2.val : 0;

            sb.append((l1_num + l2_num + temp) % 10);

            if ((l1_num + l2_num + temp) >= 10) 
                temp = 1; 
            else 
                temp = 0;  

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if(temp==1) sb.append(temp);


        for (char c : sb.toString().toCharArray()) {
            answer.next = new ListNode(c - '0');
            answer = answer.next;
        }

        return dummy.next;
    }
}
