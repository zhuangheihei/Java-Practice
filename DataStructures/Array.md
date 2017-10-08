### 169. Majority Element
*一个数组，其中有一个元素的出现次数为n/2次以上，求这个“大多数”元素。*
- 其实可以排序然后输出中间那个元素的。但这样太low了。
- 我们其实可以记录major这个数字的count数，碰到一个他自己就自加，碰别的数就自己减，减到0就换个数字。最后剩下的肯定就是majority了。
```java
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count ++;
                major = nums[i];
            }else if(major == nums[i]){
                count ++;
            }else{
                count --;
            }
        }
        return major;
    }
}
```
### 561. Array Partition I
*Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.*

Example 1:
```
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
```
**Note:**
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
- Very intuitive. Small number pair with small number, large number pair with large number.
- This is my solution:
1. Sort the array.
2. Then add the first number of pair.
Beat 70% submission.
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i+=2){
            res += nums[i];
        }
        return res;
    }
}
```
