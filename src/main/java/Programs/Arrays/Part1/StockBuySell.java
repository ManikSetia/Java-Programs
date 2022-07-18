package Programs.Arrays.Part1;

public class StockBuySell {

    public int maxProfit(int[] prices){
        int buy = Integer.MIN_VALUE,sell=Integer.MIN_VALUE, profit=Integer.MIN_VALUE;
        int maxProfit=0;

//        for(int i=0; i<prices.length; i++){
//            buy=prices[i];
//            for(int j=i+1; j<prices.length; j++){
//                if(prices[j]>prices[i]){
//                    sell=prices[j];
//                    profit=sell-buy;
//                    maxProfit=(profit>maxProfit)?profit:maxProfit;
//                }
//            }
//        }

        //Approach2: Keep track of minimum element to the left of current element
        int min=Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            min=(prices[i]<min)?prices[i]:min;//buying
            if(prices[i]>min){
                //sell the stock and compute the profit
                profit=prices[i]-min;
                maxProfit=(profit>maxProfit)?profit:maxProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices={1, 2};
        int maxProfit=new StockBuySell().maxProfit(prices);
        System.out.println("Maximum profit: "+maxProfit);
    }
}
