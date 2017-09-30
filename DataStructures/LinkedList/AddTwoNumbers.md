*Given two number as linked list, return their sum as linked list.*

- Simply add them.

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            sum %= 10;
            ListNode val = new ListNode(sum);
            cur.next = val;
            cur = cur.next;
        }
        if(carry != 0){
            ListNode last = new ListNode(carry); 
            cur.next = last;
            cur = cur.next;
        }
        
        cur.next = null;
        return fakeHead.next;
        
    }
}
```
