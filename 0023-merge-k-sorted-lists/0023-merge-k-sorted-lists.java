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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                arr.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(arr);

        ListNode answer = new ListNode(0);
        ListNode node = answer;

        for(int num : arr){
            node.next = new ListNode(num);
            node = node.next;
        }

        return answer.next;
    }
}