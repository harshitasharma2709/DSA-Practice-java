class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j= 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        int n = nums.length;
        while(j<n){
            sum +=nums[j];

            while(sum>=target){
                sum -= nums[i];
                int wlen = j-i+1;
                minSize = Math.min(minSize, j-i+1);
                i++;
            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
}
}