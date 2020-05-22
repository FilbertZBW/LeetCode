//Reference: 15.3sum
//It is really similar to 3sum by just adding an outer loop
//and one more check of duplicates

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j-1]==nums[j]){
                    continue;
                } 
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int cur=nums[i]+nums[j]+nums[left]+nums[right];
                    if(cur==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                    else if(cur<target){
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