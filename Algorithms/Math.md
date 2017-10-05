### 7. Reverse Integer
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

### 9. Palindrome Number   

*Determine whether an integer is a palindrome. Do this without extra space.*

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (x == rev || x == rev / 10);
    }
}
```

### 12. Integer to Roman
*Given an integer, convert it to a roman numeral.*

*Input is guaranteed to be within the range from 1 to 3999.*

- Know how to convert between integer and roman.
```java
class Solution {
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM","MMM"};
        String[] C = {"", "C", "CC","CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
```

### 292. Nim Game
*You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.*

*Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.*

*For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.*

- Very tricky, if the number can not be devided by 4 then we can definitely win.

```java
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
```