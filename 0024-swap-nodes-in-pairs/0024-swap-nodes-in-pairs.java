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
    public ListNode swapPairs(ListNode head) {

        ListNode answer = new ListNode(0);
        ListNode curr = answer;

        while(true){

            if(head==null) break;
            else if(head.next==null){
                curr.next = new ListNode(head.val);
                break;
            }

            curr.next = new ListNode(head.next.val);
            curr.next.next = new ListNode(head.val);
            curr = curr.next.next;

            if(head.next.next==null) break;
            else head = head.next.next;
        }

        return answer.next;
    }
}