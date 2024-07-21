package Day3;
import java.util.*;


class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        if(m==0 || n==0) return 0;
        
        Collections.sort(a);
        
        if(n<m) return -1;
        
        int minDiff = Integer.MAX_VALUE;
         
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = a.get(i + m - 1) - a.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}