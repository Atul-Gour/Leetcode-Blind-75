class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int idx=0; idx<strs.length; idx++){
            int[] chars = new int[26];
            for(char i:strs[idx].toCharArray()){
                chars[i-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i:chars){
                sb.append('#');
                sb.append(i);
            }
            map.putIfAbsent(sb.toString(),new ArrayList<>());
            map.get(sb.toString()).add(idx);
        }
        for(String key: map.keySet()){
            ArrayList<String> curr = new ArrayList<>();
            for(int i:map.get(key)){
                curr.add(strs[i]);
            }
            ans.add(curr);
        }
        return ans;
    }
}