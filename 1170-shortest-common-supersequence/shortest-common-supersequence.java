class Solution {
    
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        lcs.reverse();  

    
        StringBuilder scs = new StringBuilder();
        i = 0; 
        j = 0;
        for (char c : lcs.toString().toCharArray()) {
            while (str1.charAt(i) != c) scs.append(str1.charAt(i++)); 
            while (str2.charAt(j) != c) scs.append(str2.charAt(j++)); 
            scs.append(c); 
            i++; j++; 
        }

        
        scs.append(str1.substring(i)).append(str2.substring(j));

        return scs.toString();
    }
}