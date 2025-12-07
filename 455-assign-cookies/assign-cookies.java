class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int j=0;
        int count=0;
        for(int i=0;i<g.length && j<s.length;){
            if(s[j]>=g[i]){
                count++;
                j++;
                i++;
                continue;
            }
            while(j<s.length && s[j]<g[i])j++;
        }
        return count;
    }
}