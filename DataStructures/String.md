### 5. Longest Palindromic Substring
* Given a string s, find the longest palindromic substring in s and return it. You may assume that the maximum length of s is 1000.
    * 一种有用的方法是对当前的字符为中心扩展palindrome，但是palindrome有可能为单数也有可能为复数长度的。

 

### 6. ZigZag Conversion
*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)*
```
P   A   H   N
A P L S I I G
Y   I   R
```
*And then read line by line: "PAHNAPLSIIGYIR"*

*Write the code that will take a string and make this conversion given a number of rows:*

*string convert(string text, int nRows);*

*convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*

- The solution is clean to figure out, just read the code.

```java
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] zig = new StringBuilder[numRows];
        //Assign new StringBuilder() to each element of zig
        for(int idx = 0; idx < numRows; idx++){
            zig[idx] = new StringBuilder();
        }
        
        int i = 0;
        while (i < len) {
            //First go vertically down and then obliquely up. Done.
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                zig[idx].append(s.charAt(i++));
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                zig[idx].append(s.charAt(i++));
        }
        //Append all stringbuilder to the first one.
        for(int idx = 1; idx < numRows; idx++){
            zig[0].append(zig[idx]);
        }
        
        return zig[0].toString();
    }
}
```


### 14. Longest Common Prefix

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
### 151. Reverse Words in a String
*Given an input string, reverse the string word by word.*
```
For example,
Given s = "the sky is blue",
return "blue is sky the".
```
- Test cases are very dispicable.
```java
public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
    
        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }
    
    private void reverse(char[] str, int i, int j){
        while(i < j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    
    private String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;
      
    while (j < n) {
      while (j < n && a[j] == ' ') j++;             // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++;             // skip spaces
      if (j < n) a[i++] = ' ';                      // keep only one space
    }
  
    return new String(a).substring(0, i);
  }
    
    private void reverseWords(char[] a, int n) {
    int i = 0, j = 0;
      
    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }
}
```