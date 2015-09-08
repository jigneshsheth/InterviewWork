/**
 * 
 * @author Paul
 * Purpose: Suppose we have an array of n integers
 * that can be positive, negative, or zero. Each
 * index represents a stock market price. We can
 * only buy/sell once and we need to figure out
 * what buy/sell pair would give us the most
 * profit.
 * 
 * Algorithm: Divide and Conquer O(nlog(n))
 * Idea: We compute the best we can make
 * in the left half of array. We compute
 * the best we can make in right half and lastly
 * we compute best we can make if we buy in left 
 * and sell in right. These 3 values are then stored.
 * We pick the max of these three to get the correct 
 * solution.
 *
 */
public class StockMarketBuySell {

	
	public int stockProfit(int[] A) {
		// If no values, then no profit
		if(A.length == 0) {
			return 0;
		}
		// If only 1 value, then you also make 0 profit
		if(A.length == 1) {
			Math.max(A[0], 0);
		}
		// Half of the array
		int half = A.length / 2;
		return 0;
	}
	
	public static void main(String[] args) {
		

	}

}
