class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // If only one element
        if (n == 1) {
            return 0;
        }

        // Check first element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // Check last element
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        return -1; // peak always exists, so this won't run
    }
}