//We care about the cumulative sum, use a map to record to sums 
//and take advantage of the subtraction between two sums(which 
//represents the sum of each subarray)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}