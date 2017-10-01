*Reverse digits of an integer.*
```
Example1: x = 123, return 321
Example2: x = -123, return -321
```
- My solution is using a queue to do the reverse.
```java
class Solution {
    public int reverse(int x) {
        long res = 0;
        Queue<Integer> q = new LinkedList<>();
        while(x != 0){
            q.offer(x % 10);
            x /= 10;
        }
        
        while(q.isEmpty() == false){
            res = res * 10 + q.poll();
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            res = 0;
        }
        return (int)res;
    }
}
```
- Here is the solution from discuss.
- If overflow exists, the new result will not equal previous one.
```java
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
```