import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        return helper("", digits);
    }

    private ArrayList<String> helper(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        String[] map = {
                "", "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        int digit = up.charAt(0) - '0';

        ArrayList<String> list = new ArrayList<>();

        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            list.addAll(helper(p + ch, up.substring(1)));
        }

        return list;
    }
}