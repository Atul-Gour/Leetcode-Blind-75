class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        String s1 = String.valueOf(x);
        String s2 = new StringBuilder(s1).reverse().toString();
        if(s1.equals(s2))return true;
        else return false;
    }
}