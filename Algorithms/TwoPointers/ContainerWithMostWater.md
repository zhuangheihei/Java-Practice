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