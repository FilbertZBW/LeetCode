//Writing customized comparator is the key part
//Maintaining the size of heap guarantees low time complexity

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //sol1: sort-O(NlogN)
        //1. Count the frequency of each word using a HashMap
        //2. Flattern the HashMap to an array of word counts
        //3. Sort the word counts by descending frequency
        //4. Output first k words
        
        
        //sol2: Priority Queue-O(NlogN)
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String word1, String word2){
                int freq1 = map.get(word1);
                int freq2 = map.get(word2);
                return freq1 == freq2 ? word2.compareTo(word1) : (freq1 - freq2);
            }
        });
        
        for(String word : map.keySet()){
            pq.add(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}