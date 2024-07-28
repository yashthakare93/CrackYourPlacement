package Day10;


class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
          if (m > n) {
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, n, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int n, int m, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (currentSum + arr[i] > maxPages) {
                studentCount++;
                currentSum = arr[i];
                if (studentCount > m) {
                    return false;
                }
            } else {
                currentSum += arr[i];
            }
        }
        return true;
    }

    
};