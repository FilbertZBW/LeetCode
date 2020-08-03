//For the first level to current level, generate current row
//based on the previous row.

class Solution {  
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> curr = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            curr = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    curr.add(1);
                }else{
                    curr.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = curr;
        }
        return curr;
    }
}