class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
 
        // T: O(n)
        // S: O(1)
        // [7,1,5,3,6,4]
        //        i
        // mP = 4
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}