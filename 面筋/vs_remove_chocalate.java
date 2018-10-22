class Solution{
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        System.out.println("\nThere are " + countWays(n) + " ways to remove " + n + " chocalates.\n");
    }

    private static int countWays(int n){
        int x = 4, tmp1 = 1, tmp2 = 1, tmp3 = 2;
        if(n==1) return tmp1;
        if(n==2) return tmp2;
        if(n==3) return tmp3;
        while(x<=n){
            int count = 0;
            count += tmp1;
            count += tmp3;
            tmp1 = tmp2;
            tmp2 = tmp3;
            tmp3 = count;
            x++;
        }
        return tmp3;
    }
    
}