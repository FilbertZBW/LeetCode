//Sort the array first. For every figure except the last two, 
//explore whether there are a pair of number that add up to the inverse
//of the current figure. Dealing with duplicates is also an important part
//in this problem. If we find duplicate we need to skip them.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int left = i+1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] == 0 - nums[i]){
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < 0 - nums[i] && left < right){
                        left++;        
                    }else{
                        right--;
                    }
                }
            }
        }
                                
        return res;
    }
}