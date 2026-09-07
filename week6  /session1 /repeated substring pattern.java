class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try every possible substring length
        for (int len = 1; len <= n / 2; len++) {

            // Length must be divisible by substring length
            if (n % len != 0) {
                continue;
            }

            String pattern = s.substring(0, len);
            boolean valid = true;

            // Check whether the pattern repeats
            for (int i = len; i < n; i += len) {
                if (!s.substring(i, i + len).equals(pattern)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return true;
            }
        }

        return false;
    }
}


Input
s =
"abab"
Output
true
Expected
true
