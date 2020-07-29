class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        
        //Sort the intervals according to the starting time
        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> outputList = new ArrayList<>();
        //Set the first interval as the current interval
        int[] currentInterval = intervals[0];
        outputList.add(currentInterval);
        
        //Update current interval or add new interval
        for(int[] interval : intervals){
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }else{
                currentInterval = interval;
                outputList.add(currentInterval);
            }
        }
        
        return outputList.toArray(new int[outputList.size()][]);
    }
}