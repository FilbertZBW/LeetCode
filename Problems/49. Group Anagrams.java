//If we sort the words by character, anagrams will have the same pattern.
//So based on this, it is quite simple to use a map to solve this problem.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(strs[i]);
                map.put(sorted, list);
            }else{
                List<String> list2 = new ArrayList<>();
                list2.add(strs[i]);
                map.put(sorted, list2);
            }
        }
        for(String str : map.keySet()){
            res.add(map.get(str));
        }
        return res;
    }
}