class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row = 3;
        // col = 4;
        // n = 12;

        // row = 6/3 = 2-1;
        // col = 6%4=2-1;

        //(1,1)
        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0;
        int right = r*c-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            int midvalue = matrix[mid/c][mid%c];

            if(midvalue==target){
                return true;
            }

            if(midvalue>target){
                right= mid-1;
            } else{
                left = mid+1;
            }
        }
        return false;
    }
}