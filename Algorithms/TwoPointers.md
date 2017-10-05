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

### 344. Reverse String
*Given a string, reverse it.*

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
