public class LongestCommonSubstring1 {
    public String lcsubstring_dp(String s, String rev) {
        //Dynamic Programming Solution
        // make a dp table
         int [][] dp = new int[s.length() + 1][s.length() + 1];
        //Initialize values in the table
        for(int i = 0; i < s.length() + 1; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        //String rev = new StringBuilder(s).reverse().toString();
        //System.out.println(rev);
        StringBuilder result = new StringBuilder("");
        for(int i = 1; i < rev.length() + 1; i++){
            for(int j = 1; j < s.length() + 1; j++){
               if(s.charAt(i-1) == rev.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
               else dp[i][j] = 0;
            }
        }
        int max_elem = 0, max_i = 0, max_j = 0; 
        //Find max indices and max element
        for(int i = 1; i < s.length() + 1; i++)
            for(int j = 1; j < rev.length() + 1; j++)
                if(dp[i][j] > max_elem){max_elem = dp[i][j]; max_i = i; max_j = j;}
        //System.out.println(max_elem);
        int i = max_i, j = max_j;
        while(dp[i][j] > 0){
            result.append(s.charAt(i-1));
            i--;j--;
        }
        return result.toString();
    }
}
