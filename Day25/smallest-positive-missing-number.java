package Day25;

class Solution {
    static int missingNumber(int arr[], int size) {
        int n = size;
        
        int shift = segregate(arr, n);
        
        int[] positiveArr = new int[n - shift];
        for (int i = 0; i < n - shift; i++) {
            positiveArr[i] = arr[shift + i];
        }
   
        for (int i = 0; i < positiveArr.length; i++) {
            int num = Math.abs(positiveArr[i]);
            if (num - 1 < positiveArr.length && positiveArr[num - 1] > 0) {
                positiveArr[num - 1] = -positiveArr[num - 1];
            }
        }
  
        for (int i = 0; i < positiveArr.length; i++) {
            if (positiveArr[i] > 0) {
                return i + 1;
            }
        }
        
        return positiveArr.length + 1;
    }
    
    static int segregate(int arr[], int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
}