import java.util.*;

public class Solution {
    // Mapping of digits to corresponding letters on a phone keypad
    private static final String[] KEYPAD = {
        "",     // 0 -> No mapping
        "",     // 1 -> No mapping
        "abc",  // 2 -> "abc"
        "def",  // 3 -> "def"
        "ghi",  // 4 -> "ghi"
        "jkl",  // 5 -> "jkl"
        "mno",  // 6 -> "mno"
        "pqrs", // 7 -> "pqrs"
        "tuv",  // 8 -> "tuv"
        "wxyz"  // 9 -> "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        return pad("", digits);
    }

    public List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        String letters = KEYPAD[digit]; // Correctly retrieve letter mappings

        List<String> ans = new ArrayList<>();
        for (char ch : letters.toCharArray()) {  // Iterate over characters in the mapping
            ans.addAll(pad(p + ch, up.substring(1)));
        }

        return ans;
    }


}
