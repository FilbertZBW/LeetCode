//A really subtle way of solving this using BFS!!
//Start from the first char in the string, explore the end index that
//s.substring(start, end) is in the dict. Store the end index into the queue, 
//which can be the starting point of subsequent search. Pop the first element
//in the queue everytime as the new starting point, and explore the end point in
//the for loop. If the end point happened to be the last char in s, we got there!



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while(!queue.isEmpty()){
            int start = queue.remove();
            if(visited[start] == 0){
                for(int end = start + 1; end <= s.length(); end++){
                    if(wordDictSet.contains(s.substring(start, end))){
                        queue.add(end);
                        if(end == s.length()){
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}