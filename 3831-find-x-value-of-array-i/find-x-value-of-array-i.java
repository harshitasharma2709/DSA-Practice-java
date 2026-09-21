class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            int x = num % k;

            // Start new subarray
            next[x] = 1;

            // Extend previous subarrays
            for (int i = 0; i < k; i++) {
                int r = (int)((long)i * x % k);
                next[r] += dp[i];
            }

            // Add to answer
            for (int i = 0; i < k; i++) {
                ans[i] += next[i];
            }

            dp = next;
        }

        return ans;
    }
}