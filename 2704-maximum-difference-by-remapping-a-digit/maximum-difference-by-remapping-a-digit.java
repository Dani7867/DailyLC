class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        String maxStr = findMax(s);

        String minStr = findMin(s);

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }

    private String findMax(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '9') {
                return s.replace(c, '9');
            }
        }
        return s; // All digits are already 9
    }

    private String findMin(String s) {
        char firstDigit = s.charAt(0);
        return s.replace(firstDigit, '0');
    }
}