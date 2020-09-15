public class LongestCommonSubString {
    public static String LCS(String s1, String s2) {
        //dynamic programming
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        int max = -1;
        int maxIndex = -1;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //Meaning a contiguous sequence is extending
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //Meaning a break of combo due to mismatch
                    dp[i][j] = 0; 
                }
                max = Math.max(max, dp[i][j]);
                maxIndex = Math.max(maxIndex, j);
            }
        }

        return s2.substring(maxIndex - max, maxIndex);
    }

    public static void main(String[] args) {
        String s1 = "ACDEFG";
        String s2 = "ABCDEF";
        System.out.println(LCS(s1, s2));
    }
}
