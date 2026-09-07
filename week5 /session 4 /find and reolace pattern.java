import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        char[] map1 = new char[26]; // pattern -> word
        char[] map2 = new char[26]; // word -> pattern

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Check pattern -> word mapping
            if (map1[p - 'a'] != '\0' && map1[p - 'a'] != w) {
                return false;
            }

            // Check word -> pattern mapping
            if (map2[w - 'a'] != '\0' && map2[w - 'a'] != p) {
                return false;
            }

            map1[p - 'a'] = w;
            map2[w - 'a'] = p;
        }

        return true;
    }
}

nput
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
Expected
["mee","aqq"]
