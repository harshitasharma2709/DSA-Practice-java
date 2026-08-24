class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length; // stone
        int sum[] = new int[n];

        sum[0] = stones[0];
        for(int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + stones[i];

        int ans = sum[n - 1];

        for(int i = n - 2; i >= 1; i--)
            ans = Math.max(ans, sum[i] - ans);

        return ans;
    }
}