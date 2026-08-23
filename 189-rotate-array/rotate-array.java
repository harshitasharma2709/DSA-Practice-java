class Solution {
    public void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7]
        //  k = 3
        // [5,6,7,1,2,3,4]
        int n = nums.length;
        k = k%n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    void reverse(int[] arr, int l, int r){
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}