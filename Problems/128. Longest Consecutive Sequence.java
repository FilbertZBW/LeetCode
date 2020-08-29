//The key is to avoid duplicates by subtly using the set. 
//Check whether (num - 1) is in the set. If so, no need to
//start traversing since it is doomed not to be the longest.

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int longestStreak = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currentStreak = 0;
                int currentNum = num;
                
                while(set.contains(currentNum)){
                    currentStreak++;
                    currentNum++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}