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