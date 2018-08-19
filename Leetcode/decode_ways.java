class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int prev = Integer.valueOf(s.substring(i-1,i));
            int prev2 = Integer.valueOf(s.substring(i-2, i));
            if(prev>0 && prev<=9){
                dp[i] += dp[i-1];
            }
            if(prev2 >= 10 && prev2 <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}

/*
 - 这个题目用的是DP。和climbing stairs类似。 
 - idea就是我们要到达n，就要从n-1或者n-2过去。
 - 但是这题有变化。我们需要知道什么情况下，它可能从n-1或者n-2过去。
	 - 如果前一位是1～9，那么可以从n-1走到n；
	 - 如果前两位是在10～26之间，那么就可以从n-2走到n

 - 确实是和climbing stairs很像的题目
 - Integer.valueOf() 可以处理很多和string 和char有关的数字问题
 - **dp[0]要设置为1，因为“空string有一种decode 方式”**
 - **O(n) time, O(n) space**
*/