//Sort the array by starting time first so there won't be complex logics
//Then create a minHeap based on the ending time so that we could find the earliest
//ending room(high priority to be arranged). Traverse the array. Compare current.start with 
//earliest.end. If there is a conflict, we have to create a new room. Else, just update the earliest ending time.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        if(intervals.length == 1){
            return 1;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((interval1, interval2) -> Integer.compare(interval1[1], interval2[1]));
        minHeap.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] earliest = minHeap.remove();
            
            if(current[0] >= earliest[1]){
                earliest[1] = current[1];
            } else {
                minHeap.add(current);
            }
            
            minHeap.add(earliest);
        }
        
        return minHeap.size();
    }
}