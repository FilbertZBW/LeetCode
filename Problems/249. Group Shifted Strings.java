class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        //stores types and their corresponding 
         Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            //convert s to a general type
            String encoded = encode(s);
            if(!map.containsKey(encoded)){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(encoded, list);
            }else{
                List<String> list1 = map.get(encoded);
                list1.add(s);
                map.put(encoded, list1);
            }
        }
        
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
    
    private String encode(String s){
        if(s.length() == 1){
            return "-1";
        }
        
        StringBuilder sb = new StringBuilder();
        
        //it is no matter what the first character is
        for(int i = 1; i < s.length(); i++){
            sb.append((s.charAt(i)-s.charAt(0)+26) % 26); //distance from the first char
            sb.append("."); //fantastic! distinguish a two-digit number from two one-digit numbers
        }
        
        return sb.toString();
    }
}