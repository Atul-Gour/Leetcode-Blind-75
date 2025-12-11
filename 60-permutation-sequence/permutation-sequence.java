class Solution {
    static int checked = 0;
    static ArrayList<Integer> ans;

    static void check(int n , int k , int index , boolean[] visited , ArrayList<Integer> list){
        if(ans != null)return; 

        if(index == n){
            if(checked == k-1) ans = new ArrayList<>(list);
            else checked++;

            return;
        }

        for(int i = 1 ; i <= n ; i++){
            if(visited[i])continue;

            visited[i] = true;

            list.add(i);
            check(n , k , index + 1 , visited , list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public String getPermutation(int n, int k) {
        check(n , k , 0 , new boolean[n+1] , new ArrayList<>());

        StringBuilder sb = new StringBuilder();

        for (Object x : ans) {
            sb.append(x);
        }

        String result = sb.toString();

        ans = null;
        checked= 0;
        
        return result;
    }
}