class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void generateSubsets(int index, int[] nums, List<Integer> curr,  List<List<Integer>> res){
        res.add(new ArrayList<>(curr));

        //add and remove represents the choose and not choose operation
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            generateSubsets(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}