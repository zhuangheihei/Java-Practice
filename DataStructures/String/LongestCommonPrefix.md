*Write a function to find the longest common prefix string amongst an array of strings.*

- Use .indexOf() to find out if there is common prefix.
- Use substring to shorten the length of prefix.
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
```