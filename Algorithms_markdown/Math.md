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
### 66. Plus One
*给一个用数组表示的整数，给它加上1. 该数组没有leading和trailing zeros。*
- 其实很简单，需要一个新数组的情况就是所有的位数都是9。如果一个数不是9，那么长度就不变。
- 如果一个位上不为9，那么它自加1即可。如果为9，那么置0，下一位加1.
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
```
### 292. Nim Game
*一堆石头，一个人能拿1-3个，我先拿，朋友后拿。问什么情况下我必然能赢？*
- Very tricky, if the number can not be devided by 4 then we can definitely win.

```java
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
```
