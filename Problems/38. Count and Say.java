//to come up with current result, use previous result, 
//traverse it and keep track of current and prev items.

class Solution {
    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        //initialize string
        String res = "1";
        
        //build string one by one
        for(int i = 1; i < n; i++){
            int count = 0;
            char prev = '.';
            StringBuilder sb = new StringBuilder();
            //build up the current string
            for(int j = 0; j < res.length(); j++){
                //if duplicate item or the first item, increase count by 1
                //else, reset the count to 1.
                //the prev should always be current index
                if(res.charAt(j) == prev || prev == '.'){
                    count++;
                }else{
                    sb.append(count+Character.toString(prev));
                    count = 1;
                }
                prev = res.charAt(j);
            }
            sb.append(count + Character.toString(prev));
            res = sb.toString();
        }
        
        return res;
    }
}