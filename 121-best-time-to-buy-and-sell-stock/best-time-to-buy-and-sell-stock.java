class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        
        // [7, 1, 5, 3, 6, 4]
        //     p
        // minprice = 1
        // maxprice = 0
        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }
        
            if(price - minPrice > maxPrice){
                maxPrice = price - minPrice;
            }
        }
        return maxPrice;
    }
}