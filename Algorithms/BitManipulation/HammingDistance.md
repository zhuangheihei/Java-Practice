*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.*

*Given two integers x and y, calculate the Hamming distance.*

*Note:*
*0 ≤ x, y < 231.*

Example:
```
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
```

- **Simply use xor to find all different bit, and count them.**
- **Note the proper usage of ">>" and "<<".**

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int dist = 0;
        while(res != 0){
            if((res & 1) == 1) dist ++;
            res = res >> 1;
        }
        return dist;
    }
}
```