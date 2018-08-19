/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode fh = new ListNode(0), slow = fh, fast = fh;
        fh.next = head;
        for(int i=1;i<=n+1; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return fh.next;
    }
}

/*
    快慢指针法：
    需要一个fakehead来避免[1], n=1时指针越界的情况
    fast指针先往前走n+1步，当fast指针走到尾巴的时候，slow指针刚好在要被移除的node的前一个node，那么就可以
    移除node。

*/