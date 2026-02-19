package main.java;

public class BuyAndSellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices= {7,1,5,3,6,4};
		int min=Integer.MAX_VALUE;
		int maxStocks=0;
		for(int i=0; i<prices.length;i++) {
			if(min>prices[i]) {
				min=Math.min(min, prices[i]);
			} else if(prices[i]-min>maxStocks) {
				maxStocks=prices[i]-min;
			}
		}
		System.out.println(maxStocks);
	}
	

}
