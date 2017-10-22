### 2. Add Two Numbers
*Given two number as linked list, return their sum as linked list.*

- 就
 
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
### 141. LinkedList Cycle
* Given a linked list, determine if it has cycle.
    * Use two pointers, fast and slow, fast goes two steps each time, slow goes one step.
    * If there is cycle, two pointers will finally meet.
    * Becareful when checking if the pointer exceed their boundary.

### 148. Sort List(More Practice)
* Sort a list in O(nlogn) time complexity and constant space complexity.
    * Sort the list in O(nlogn) means using merge sort.
    * Pay attention that when deviding the list into two parts, need to set the left part's tail points to null, otherwise stack overflow error occurs.
```java
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; //when the list has only one element, no need to sort
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        //Devide list into two part
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; //这一句是用来截开前后两个list的，前一半list的尾部也要是null，否则递归时会stackoverflow.
        
        //Sort each part, recursive call
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else if(l2.val < l1.val){
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        
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

