### 2. Add Two Numbers
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
### 21. Merge Two Sorted Lists
*给两个sorted list，将它们merge成一个新list，要求新list的node要是原来两个list的nodes*
- 需要创建一个新的list。挨个比较两个list的node值即可。
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }else{
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }
            }else{
                if(l1 != null){
                    cur.next = l1;
                    cur = cur.next; 
                    l1 = l1.next;
                }else if(l2 != null){
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
        }
        return fakeHead.next;
    }
}
```
### 206. Reverse Linked List
*Reverse a singly linked list.*

- Code is easy and clean. 
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```


### 237. Delete Node in Linked List
*Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.*

*Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.*

- Since we couldn't enter the preceding node, we can not delete the given node. We can just copy the next node to the given node and delete the next one.
- Stupid question.
```java
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

