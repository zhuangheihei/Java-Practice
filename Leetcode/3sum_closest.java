class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        // need to assign res a default result
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i<n-2; i++){
            int j=i+1, k=n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>target){
                    k--;
                }else{
                    j++;
                }
                
                if(Math.abs(target-sum)<Math.abs(target-res)){
                    res = sum;
                }
            }
        }
        return res;
    }
}



/*
    Similar to 3 Sum problem, use 3 pointers to point current element, next element 
    and the last element. If the sum is less than target, it means we have to add a 
    larger element so next element move to the next. If the sum is greater, it means 
    we have to add a smaller element so last element move to the second last element. 
    Keep doing this until the end. Each time compare the difference between sum and 
    target, if it is less than minimum difference so far, then replace result with it, 
    otherwise keep iterating.

*/