class Solution{
    public int epeatedStringMatch(String A, String B){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.indexOf(B)==-1 && sb.length()<B.length()){
            sb.append(A);
            count++;
        }
        // we need to add one more A and check if it works
        if(sb.indexOf(B)==-1){
            sb.append(A);
            count++;
        }
        return sb.indexOf(B)==-1 ? -1:count;
    }
}



/*
    The idea is to keep string builder and appending until the length A is greater or equal to B.
    And use .contains() to check if B is substring of A.
    If the stringbuilder doesn't contains B after the loop, we add one more A and check if it works
    (这样可以处理这种情况A="abc", B="cab"，如果此时还找不到，说明无法匹配). If yes, return ++count, ; if not, 
    return -1;
*/