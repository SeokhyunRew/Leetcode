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

        

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenCurr = evenHead;

        while(evenCurr!=null && evenCurr.next!=null){
            oddHead.next = evenCurr.next;
            oddHead = oddHead.next;

            evenCurr.next = oddHead.next;
            evenCurr = evenCurr.next;
        }

        oddHead.next = evenHead;

        return head;
    }
}