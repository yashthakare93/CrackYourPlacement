package Day1;

class Solution {
    public int removeDuplicates(int[] ar) {
        int j=0;
        for(int i=1;i<ar.length;i++){
            if(ar[j] != ar[i]){
                j++;
                ar[j]=ar[i];
            }
        }
         return j+1;
    }
}