public class CoinChange
{
	public static void main(String[] args)
	{
		final int AMOUNT = 12;
		int [] coins = {1,2,5};
		System.out.println("Number of combinations of amount " + AMOUNT + " is " + change(AMOUNT, coins));
		
	}
	
	// using iterative approach to calculate the number of combinations of a given 
	// amount of money
	// time complexity if O(mn)
	// space complexity if O(n)
	public static int change(int moneyAmount, int [] coins)
	{
		int [] combinations = new int [moneyAmount + 1];
		combinations[0] = 1;
		
		for(int coin: coins)
		{
			for(int amount = 0; amount < combinations.length; ++amount)
			{
				if(amount >= coin)
				{
					combinations[amount] += combinations[amount - coin];
				}
			}
		}
		if(combinations[moneyAmount] == 0) // if no combination(s) found, return -1
			return -1;
		else
			return combinations[moneyAmount];
	}
	// helper method to show the combinations
	public static void printCombinations(int [] arr)
	{
		for(int i = 0; i < arr.length; ++ i)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}