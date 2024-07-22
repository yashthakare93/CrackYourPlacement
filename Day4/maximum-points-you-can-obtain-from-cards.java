package Day4;
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        max = leftSum;

        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - 1 - i];
            leftSum += cardPoints[n - 1 - i];
            max = Math.max(max, leftSum);
        }

        return max;
    }
}

