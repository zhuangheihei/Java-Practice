### 104. Maximum Depth of Binary Tree

*Given a binary tree, find its maximum depth.*

*The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*

- Using recursion to do DFS, done.
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
```

### 226. Invert Binary Tree
* Given a binary tree, invert it.
    * Write a helper function with void return value. It will get the job done.
    * In the helper function, first go all the way down to the leaf nodes, then invert them level by level.
