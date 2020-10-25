class Solution {
    public String decodeString(String s) {
        //1. Using Stack
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            //decode from the innermost shell
            if(s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            }else{
                StringBuilder decodedStr = new StringBuilder();
                
                while(stack.peek() != '['){
                    decodedStr.append(stack.pop());
                }
                stack.pop(); //pop '[' out
                int base = 1;
                int k = 0;
                
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                while(k > 0){
                    for(int j = decodedStr.length() - 1; j >= 0; j--){
                        stack.push(decodedStr.charAt(j));
                    }
                    k--;
                }
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        } 
        return res.reverse().toString();
    }
}