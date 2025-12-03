class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        Map<Character, Integer> val = new HashMap<>();

        val.put('(', 1);
        val.put('[', 2);
        val.put('{', 3);
        val.put(')', 4);
        val.put(']', 5);
        val.put('}', 6);
        
        int[] arr = {0,4,5,6};

        Stack<Integer> close = new Stack<>();
        

        for(char c: s.toCharArray()){
            int curr= val.get(c);
            
            if(curr>3 ){
                if (close.isEmpty())return false;
                else{
                    if(close.peek()!=curr)return false;
                    else{
                        close.pop();
                    }
                    
                }
            }else{
                close.push(arr[curr]);
            }
        }
        if(!close.isEmpty())return false;
        return true;
    }
}