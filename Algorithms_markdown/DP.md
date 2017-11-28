### 53. Maximum Subarray
* Given a array, find the subarray with maximum sum.
  * Using DP to solve. dp[i] is the maximum sum of subarray end with nums[i].
  * The state tranfering function is dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
  * Then traverse the dp[] array to find the maximum subarray sum.
### 70. Climbing Stairs
* Each time can climb 1 or 2 steps. Stairs take n steps to the top. How many distinct ways to climb to top? 
  * dp[i] is how many distinct ways of climbing.
  * To reach the ith level of stairs, we need to go from either i-1 or i-2.
  * So dp[i] = dp[i-1] + dp[i-2].
  * The initial state of dp[] is dp[0] = 1, dp[1] = 1.
