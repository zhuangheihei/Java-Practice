*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.*
```
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
```
You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

- 重点就是比较target，头指针和尾指针，看它们具体在哪个部分
- corner case还蛮多的，要详细考虑
```
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
