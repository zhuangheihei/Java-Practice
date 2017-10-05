### 4. Median of Two Sorted Arrays   
*There are two sorted arrays nums1 and nums2 of size m and n respectively.*

*Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).*
```
Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```
```
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
[Solution & Explanation](https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation?page=1)
- Hard题的解释就是长，只能贴上链接慢慢看了。
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if(N1 < N2) return findMedianSortedArrays(nums2, nums1);
        
        int lo = 0, hi = N2 * 2;
        while(lo <= hi){
            int mid2 = (lo + hi)/2;
            int mid1 = N1 + N2 - mid2;
            //Get l1, l2, r1, r2 respectively
            double l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1)/2];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1)/2];
            double r1 = (mid1 == N1 * 2)? Integer.MAX_VALUE : nums1[(mid1)/2];
            double r2 = (mid2 == N2 * 2)? Integer.MAX_VALUE : nums2[(mid2)/2];
            
            if(l1 > r2) lo = mid2 + 1; //nums1's left part is too large, move cut 2 left;
            else if(l2 > r1) hi = mid2 - 1; // nums2's left part is too large, move cut 2 left;
            else return (Math.max(l1, l2) + Math.min(r1, r2))/2; //else it is the right cut;
        }
        return -1;
    }
}
```

### 33. Search in Rotated Sorted Array
*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.*
```
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
```
*You are given a target value to search. If found in the array return its index, otherwise return -1.*

*You may assume no duplicate exists in the array.*

- 重点就是比较target，头指针和尾指针，看它们具体在哪个部分
- corner case还蛮多的，要详细考虑
```java
class Solution {
public:
    int search(vector<int>& nums, int target) {
        //key is to compare the target, head pointer and tail pointer
        
        int i=0;
        int j=nums.size()-1;
        int res=-1;
        
        while(i<=j){
            
            int mid=(i+j)/2;
            
            if(nums[mid]==target) return mid;
            else if(nums[i]==target) return i;
            else if(nums[j]==target) return j;
            else if((j==i || j==i+1) && res==-1) return -1;
            
            //determine which section the target is
            if(target<nums[mid]){
                // in the front part
                if((nums[mid]>nums[i] && target>nums[i] )|| (nums[mid]<nums[j])) j=mid; 
                else i=mid;
                
            }
            
            if(target>nums[mid]){
                //in the back part
                if((nums[mid]<nums[j] && target<nums[j])||(nums[mid]>nums[i])) i=mid; 
                
                else j=mid;
            }
            
        }
       
       return res;
        
    }
};
```
