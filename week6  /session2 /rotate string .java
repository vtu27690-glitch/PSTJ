class Solution {
    public boolean rotateString(String s, String goal) {

        // Lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is a rotation of s
        return (s + s).contains(goal);
    }
}

Input
s =
"m"
goal =
"f"
Output
false
Expected
false
