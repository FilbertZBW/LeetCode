class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> seen){
        if(seen.size() == nums.length){
            res.add(new ArrayList<>(seen));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(seen.contains(nums[i])){
                continue;
            }
            seen.add(nums[i]);
            backtrack(nums, res, seen);
            seen.remove(seen.size() - 1);
        }
    }
}