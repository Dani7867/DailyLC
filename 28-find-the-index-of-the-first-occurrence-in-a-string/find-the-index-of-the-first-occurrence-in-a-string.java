class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return -1;
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] pi = computePI(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] computePI(String needle) {
        int m = needle.length();
        int[] pi = new int[m];
        int j = 0;
        pi[0] = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            pi[i] = j;
        }
        return pi;
    }
}