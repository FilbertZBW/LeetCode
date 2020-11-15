class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(curr[1] > intervals[i][0]){
                return false;
            }else{
                curr = intervals[i];
            }
        }
        return true;
    }
}
