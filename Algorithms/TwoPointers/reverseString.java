/*
    Given a string, reverse it.
*/
class Solution {
    public String reverseString(String s) {
        char[] rev = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char temp = rev[i];
            rev[i] = rev[j];
            rev[j] = temp;
            i++;
            j--;
        }
        return new String(rev);
    }
}