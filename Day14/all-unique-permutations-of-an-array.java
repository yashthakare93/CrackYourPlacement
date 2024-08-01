package Day14;

import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(arr, new boolean[n], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(ArrayList<Integer> arr, boolean[] used, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (used[i] || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            current.add(arr.get(i));
            backtrack(arr, used, current, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

}