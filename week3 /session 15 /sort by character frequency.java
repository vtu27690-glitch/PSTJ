

mport java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count the frequency of each character
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // Put characters into a list and sort by frequency descending
        List<Character> chars = new ArrayList<>(countMap.keySet());
        chars.sort((a, b) -> countMap.get(b) - countMap.get(a));
        
        // Build the resulting string using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int freq = countMap.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
Input
s =
"tree"
Output
"eert"
Expected
"eert"
