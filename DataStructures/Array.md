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
### 229. Majority Element II
*求一个数组中出现次数超过3/n的所有元素。*
- 用的是Boyer-Moore Majority Vote algorithm。其实就是上面一题的扩展，方法是一样的。
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int major1 = 0, major2 = 1,count1 = 0, count2 = 0;
        for(int num: nums){
            //注意这里要先把count++放前面。
            if(num == major1)
                count1 ++;
            else if(num == major2)
                count2 ++;
            else if(count1 == 0){
                major1 = num;
                count1 ++;
            }else if(count2 == 0){
                major2 = num;
                count2 ++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        //统计两个数出现次数是否超过了N/3
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == major1) 
                count1++;
            else if(nums[i] == major2) 
                count2++;
        }
        if(count1 > nums.length / 3)
            res.add(major1);
        if(count2 > nums.length / 3)
            res.add(major2);
        return res;
    }
}
```
### 283. Move Zeroes
*给一个数组，将0都移到数组后面去，其他非0元素顺序保持不变*
- 遍历数组，用一个count记录非0元素的个数，将nums[count]赋为第count个非零元素，然后count++.
- 最后将count及之后的元素置为0即可
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
        }
        
        for(int i = count; i < nums.length; i++){
            nums[i] = 0;
        }
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
