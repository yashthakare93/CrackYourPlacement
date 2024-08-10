package Day23;

class Solution {
    public static int calculateMinimumCoins(int[] coins, int rem, int[] counter) {
        int result = 0;
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (counter[rem - 1] != Integer.MAX_VALUE)
            return counter[rem - 1];
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            result = calculateMinimumCoins(coins, rem - coins[j], counter);
            if (result >= 0 && result < minimum)
                minimum = 1 + result;
        }
        if (minimum != Integer.MAX_VALUE)
            counter[rem - 1] = minimum;
        else
            counter[rem - 1] = -1;
        return counter[rem - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] l = new int[amount];
        Arrays.fill(l, Integer.MAX_VALUE);

        return calculateMinimumCoins(coins, amount, l);
    }
}