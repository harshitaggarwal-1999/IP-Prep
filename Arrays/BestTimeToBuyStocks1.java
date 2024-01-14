class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int currPrice = prices[i];
            if(currPrice <= buyingPrice){
                buyingPrice = prices[i];
            }else{
                int currProfit = currPrice-buyingPrice;
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }

        return maxProfit;
    }
}