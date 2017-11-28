### 3. Longest Substring Without Repeating Characters 

*Given a string, find the length of the longest substring without repeating characters.*

*Examples:*

*Given "abcabcbb", the answer is "abc", which the length is 3.*

*Given "bbbbb", the answer is "b", with the length of 1.*

*Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*

- Need two pointers to indicates the substring and their length;
- HashMap is for storing of indexes of chars in each string and if we meet the repeating one, we skip the repeating one by using HashMap.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] str = s.toCharArray(); 
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        for(int i = 0, j = 0; j < n;j++){
            if(map.containsKey(str[j])){
                i = Math.max(i, map.get(str[j]) + 1); //skip the repeating one
            }
            map.put(str[j], j); //record each char's index
            maxLen = Math.max(maxLen, j - i + 1);
        }
        
        return maxLen;
    }
}
```

### 11. Container With Most Water
*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.*

*Note: You may not slant the container and n is at least 2.*

- Start from the widest container(i = 0, j = n - 1)
- Calculate the maxArea
- Compare two lines, move the shorter one to inner area.
- Repeat the process. We will finally reach the maximum value.
```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxA = 0;
        int i = 0, j = n - 1;
        while(i < j){
            maxA = Math.max(maxA, Math.min(height[i], height[j])*(j - i));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxA;
    }
}
```
### 15. 3Sum
*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.*
- 用Two pointers。固定第一个指针i，然后后面用two pointers做two sum，target就是 -nums[i]
- 找到three sum后就将它放入res中，同时跳过重复的元素。三个指针都要跳。
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();        
        for(int i = 0; i < nums.length; i++){
            int target = - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            //跑后面两个指针
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum > target) r--;
                else if(sum < target) l++;
                else {//找到three sum了
                    ArrayList<Integer> temp = new ArrayList<>();    
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    //输出答案后找是否有重复的，有就跳过
                    while(l < r && nums[l] == temp.get(1)){
                        l++;
                    }
                    //输出答案后找重复的东西
                    while(l < r && nums[r] == temp.get(2)){
                        r--;
                    }
                }
            }
            //跳过重复的nums[i]
            while(i+1 < nums.length && nums[i+1] == nums[i]){ i++;}
        }
        return res;
    }
}
```


### 344. Reverse String
*Given a string, reverse it.*
- 简单题
- Easy problem, don't need to say more.
```java
class Solution {
    public String reverseString(String s) {
        char[] rev = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char temp = rev[i];
            rev[i] = rev[j];
            rev[j] = temp;
            i++;
            j--;
        }
        return new String(rev);
    }
}
```
