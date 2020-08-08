//Traverse from the end of array, find the first position i that nums[i] < nums[i+1]
//Then traverse from the end again, find the first index j that nums[i] < nums[j].
//Swap nums[i] and nums[j], then reverse all the elements after i.



class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        
        int n = nums.length - 1;
        int i = n - 1;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        int j = n;
        if(i >= 0){
            while(i < j && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1, n);
    }
    
    private void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    
    private void reverse(int[] arr, int low, int high){
        while(low < high){
            swap(arr, low, high);
            low++;
            high--;
        }
    }
}