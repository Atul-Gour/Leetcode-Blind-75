class Solution {
    public boolean ispalindrome(char[] arr,int start, int end){
        for(;start<end;start++,end--){
            if(arr[start]!=arr[end])return false;
        }
        return true;
    }
    public String longestPalindrome(String s) {
       char[] arr=s.toCharArray();
       String result="";

       if(s.length()<2)return s;

       int n=arr.length;

       for(int i=0;i<n-1;i++){
        for(int j=i;j<n;j++){
            if(ispalindrome(arr,i,j)==true){
                int currentLength = j - i + 1;
                if (currentLength >= result.length())
                result=s.substring(i, j + 1);
            }
        }
        }
       return result;
    }
}