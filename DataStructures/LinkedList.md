### 2. Add Two Numbers
给定两个用链表表示的数字，以链表形式输出它们的和。链表

* 就把它们都加在一起就行了。对链表的操作尤其要注意当前的pointer是否指向了null。
* 这题还要注意一个最高位的carry的问题。

### 445. Add Two Numbers II
同样是给两个用链表表示的数字，
---
### 21. Merge Two Sorted Lists
*给两个sorted list，将它们merge成一个新list，要求新list的node要是原来两个list的nodes*
- 需要创建一个新的list。挨个比较两个list的node值即可。

### 141. LinkedList Cycle
* Given a linked list, determine if it has cycle.
    * Use two pointers, fast and slow, fast goes two steps each time, slow goes one step.
    * If there is cycle, two pointers will finally meet.
    * Becareful when checking if the pointer exceed their boundary.

### 148. Sort List(More Practice)
* Sort a list in O(nlogn) time complexity and constant space complexity.
    * Sort the list in O(nlogn) means using merge sort.
    * Pay attention that when deviding the list into two parts, need to set the left part's tail points to null, otherwise stack overflow error occurs.

    
### 206. Reverse Linked List
*Reverse a singly linked list.*
- Code is easy and clean. 


### 237. Delete Node in Linked List
*Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.*

*Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.*

- Since we couldn't enter the preceding node, we can not delete the given node. We can just copy the next node to the given node and delete the next one.
- Stupid question.

