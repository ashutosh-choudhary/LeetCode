public class Solution {
    public int minDistance(String word1, String word2) {
        // Unsuccessful code using LCS
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i< m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0||j==0) dp[i][j] = 0;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int[] mind = new int[dp[m][n]+1];
        int[] nind = new int[dp[m][n]+1];
        int lcsindex = 0;
        int i=m, j=n;
        int si=m, sj=n;
        while(i>0 && j>0 && dp[i][j]>0){
            if(dp[i][j] == dp[i-1][j-1]) {i--;j--;}
            else{
                if(dp[i][j] == dp[i-1][j]) i--;
                else if(dp[i][j] == dp[i][j-1]) j--;
                else{
                    mind[lcsindex] = si-i;
                    nind[lcsindex] = sj-j;
                    lcsindex++;
                    si = --i;
                    sj = --j;
                }
            }
        }
        mind[lcsindex] = i;
        nind[lcsindex] = j;
        int ans = 0;
        for(i=0; i<lcsindex+1; i++)
            ans += Math.max(mind[i],nind[i]);
     
     return ans;   
    }
}
