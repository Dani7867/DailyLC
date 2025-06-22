class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = (int) Math.ceil((double) s.length() / k);
        String[] res = new String[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder group = new StringBuilder();

            for (int j = 0; j < k; j++) {
                if (idx < s.length()) {
                    group.append(s.charAt(idx++));
                } else {
                    group.append(fill);
                }
            }

            res[i] = group.toString();
        }

        return res;
    }
}
