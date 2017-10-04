*Determine whether an integer is a palindrome. Do this without extra space.*

- Use a extra int rev to store the reversed back half of x.
- Note that x's length mignt be odd or even, need a judgement.

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

