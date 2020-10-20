class Solution {
    public int[][] kClosest(int[][] points, int K) {
//O(NlogN) solution: Sort
//         int[][] res = new int[K][2];
        
//         int[][] dists = new int[points.length][2];
//         for(int i = 0; i < points.length; i++){
//             dists[i][0] = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
//             dists[i][1] = i;
//         }
        
//         Arrays.sort(dists, (dist1, dist2) -> Integer.compare(dist1[0], dist2[0]));
        
//         for(int i = 0; i < K; i++){
//             int index = dists[i][1];
//             res[i] = points[index];
//         }
        
//         return res;
        
//O(NlogK) solution: maxHeap   
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > K){
                maxHeap.remove();
            }
        }
        
        int[][] res = new int[K][2];
        while(K > 0){
            K--;
            res[K] = maxHeap.remove();
        }
        
        return res;
    }
}