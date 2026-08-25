class Solution {
    public int missingMultiple(int[] nums, int k) {
        for(int j = k; ; j += k) {
            boolean found = false;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == j) {
                    found = true;
                    break;
                }
            }
            if(!found)
                return j;
        }
    }
}