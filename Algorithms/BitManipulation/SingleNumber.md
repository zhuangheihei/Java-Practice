
 *Given an array of integers, every element appears twice except for one. Find that single one.*
  
 Note:
 *Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*

- Using xor. Two number with the same value xor will equals to zero.

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
```
