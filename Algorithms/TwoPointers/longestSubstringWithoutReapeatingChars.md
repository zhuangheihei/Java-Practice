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