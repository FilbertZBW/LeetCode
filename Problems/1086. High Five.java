//What's new: usage of PriorityQueue!


class Solution {
    public int[][] highFive(int[][] items) {
        //treeMap stores id in correct order as required in the problem
        Map<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();

        //put id and heap of score in treeMap and only keeps 
        //biggest five scores in each heap
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            if(treeMap.containsKey(id)){
                PriorityQueue<Integer> pq = treeMap.get(id);
                pq.offer(score);
                if(pq.size() > 5){
                    pq.poll();
                }
                treeMap.put(id, pq);
            }else{
                PriorityQueue<Integer> ini = new PriorityQueue<Integer>();
                ini.offer(score);
                treeMap.put(id, ini);
            }
        }
        
        //calculate average. That's simpler than the previous step!
        int[][] res = new int[treeMap.size()][2];
        int i = 0;
        for(int id : treeMap.keySet()){
            PriorityQueue<Integer> pq = treeMap.get(id);
            int sum = 0;
            while(!pq.isEmpty()){
                sum += pq.poll();
            }
            res[i][0] = id;
            res[i][1] = sum/5;
            i++;
        }
        
        return res;
        
    }
}