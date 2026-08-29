class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for(int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x,y) -> x[0] - y[0]);

        int start = 0;

        while(start < n) {
            int end = start;

            while(end + 1 < n && a[end + 1][0] - a[end][0] <= limit)
                end++;

            int[] pos = new int[end - start + 1];

            for(int i = start; i <= end; i++)
                pos[i - start] = a[i][1];

            Arrays.sort(pos);

            for(int i = 0; i < pos.length; i++)
                nums[pos[i]] = a[start + i][0];

            start = end + 1;
        }

        return nums;
    }
}