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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode answer = new ListNode(0);
        ListNode currAnswer = answer;
        ListNode currHead = head;

        while(currHead != null){
            currAnswer.next = new ListNode(currHead.val);
            currAnswer = currAnswer.next;
            currHead = (currHead.next != null) ? currHead.next.next : null;
        }

        head = head.next;

        while(head != null){
            currAnswer.next = new ListNode(head.val);
            currAnswer = currAnswer.next;
            head = (head.next != null) ? head.next.next : null;
        }

        return answer.next;
    }
}