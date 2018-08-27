/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode cur = head, prev = fh;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return fh.next;
    }
}

/*
    Use a fh to avoid the case where there is only 1 node in list.
    
*/