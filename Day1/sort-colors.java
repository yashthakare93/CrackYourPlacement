package Day1;

class Solution {
    public void sortColors(int[] nums) {
        int i=0, j=0, k=nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums,i,j);
                i++;
                j++;
            }
            else if(nums[j]==1){
                j++;
            }
            else{
                swap(nums,j,k);
                k--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}