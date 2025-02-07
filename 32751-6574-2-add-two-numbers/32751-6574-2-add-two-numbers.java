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

        StringBuilder sb_1 = new StringBuilder();
        StringBuilder sb_2 = new StringBuilder();

        while (l1 != null) {
            sb_1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb_2.append(l2.val);
            l2 = l2.next;
        }

        sb_1.reverse();
        sb_2.reverse();

        // \U0001f525 `BigInteger` 사용하여 초대형 숫자도 변환 가능
        BigInteger num1 = new BigInteger(sb_1.toString());
        BigInteger num2 = new BigInteger(sb_2.toString());
        BigInteger sum = num1.add(num2);

        sb_1.setLength(0);
        sb_1.append(sum.toString());
        sb_1.reverse();

        for (char c : sb_1.toString().toCharArray()) {
            answer.next = new ListNode(c - '0');
            answer = answer.next;
        }

        return dummy.next;
    }
}
