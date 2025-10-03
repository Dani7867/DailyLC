class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
    StringBuilder res = new StringBuilder();
        while(i >= 0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j>=0){
                sum += b.charAt(j) - '0';
                j--;
            }

             // The binary digit for the current position is sum % 2
            res.append(sum % 2);
            
            // The carry for the next position is sum / 2
            carry = sum / 2;

        }
        if(carry != 0){
            res.append(carry);
        }

        return res.reverse().toString();
    }
}