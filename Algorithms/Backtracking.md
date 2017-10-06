### 17. Letter Combinations of a Phone Number (Medium)
*给定一串字符串，代表输入的电话键盘上的数字，求能够组合成多少种可能的字符串？*

这题其实和combinations挺像的，就都是在一定的数字范围之内找组合，不同的是，这里的每一次recursive里边要组合的元素都是不同范围的。这题可以和combination类比一下。
```
public class Solution {
    private static final String[] keys = {"", "", "abc", "def", 
    "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;
        StringBuilder temp = new StringBuilder(); 
        backtrack(res, temp, digits, 0);
        return res;
    }
    
    private void backtrack(ArrayList<String> res, StringBuilder temp, 
    String digits, int ind){
        if(temp.length() == digits.length()){
            res.add(new String(temp.toString()));
            return;
        }
        String letters = keys[digits.charAt(ind) - '0'];
        
        for(int i = 0; i < letters.length(); i++){
             temp.append(letters.charAt(i));
            backtrack(res, temp, digits, ind + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```
