package Day25;


class Solution {
    public int minSwaps(int nums[]) {
        int n = nums.length;

        int[] numsCopy = nums.clone();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));

 
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        for (int i = 0; i < n; i++) {
           
            if (visited[i] || arr[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}