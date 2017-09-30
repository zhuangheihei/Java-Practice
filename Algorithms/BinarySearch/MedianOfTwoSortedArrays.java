/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation?page=1
*/

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