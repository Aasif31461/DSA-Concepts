import java.util.*;

/**
 * StringConcepts: DSA String Concepts in Java
 *
 * This file demonstrates all important string-related algorithms and concepts for DSA.
 * Topics covered:
 * 1. Anagram Check (two ways)
 * 2. Palindrome Check
 * 3. String Reversal
 * 4. Substring Search (Naive)
 * 5. Character Frequency
 * 6. Remove Duplicates from String
 * 7. String to Integer (atoi)
 * 8. Integer to String
 * 9. Longest Common Prefix
 * 10. String Rotation Check
 * 11. Contains Duplicate in Array (utility)
 */

public class StringConcepts {
    public static void main(String[] args) {
        // 1. Anagram Check
        System.out.println("isAnagram? " + isAnagramEffective("anagram", "nagaram"));
        System.out.println("isAnagram (sort)? " + isAnagram("listen", "silent"));

        // 2. Palindrome Check
        System.out.println("isPalindrome? " + isPalindrome("racecar"));

        // 3. String Reversal
        System.out.println("Reverse: " + reverseString("hello"));

        // 4. Substring Search
        System.out.println("Index of 'ana' in 'banana': " + substringSearch("banana", "ana"));

        // 5. Character Frequency
        System.out.println("Char frequency: " + charFrequency("hello world"));

        // 6. Remove Duplicates
        System.out.println("Remove duplicates: " + removeDuplicates("programming"));

        // 7. String to Integer
        System.out.println("String to int: " + stringToInt("-12345"));

        // 8. Integer to String
        System.out.println("Int to string: " + intToString(-6789));

        // 9. Longest Common Prefix
        System.out.println("Longest common prefix: " + longestCommonPrefix(new String[]{"flower","flow","flight"}));

        // 10. String Rotation
        System.out.println("Is rotation? " + isRotation("waterbottle", "erbottlewat"));

        // 11. Contains Duplicate in Array
        System.out.println("Contains duplicate? " + containsDuplicateList(new int[]{1,2,3,4,4}));

        // 12. Longest Substring Without Repeating Characters
        System.out.println("Longest substring without repeating: 'abcabcbb' -> " + longestSubstringWithoutRepeating("abcabcbb"));

        // 13. Longest Palindromic Substring
        System.out.println("Longest palindromic substring: 'babad' -> " + longestPalindromicSubstring("babad"));

        // 14. Check if String is a Permutation of Another
        System.out.println("Is permutation? 'abc', 'cab' -> " + isPermutation("abc", "cab"));

        // 15. String Compression
        System.out.println("String compression: 'aabcccccaaa' -> " + compressString("aabcccccaaa"));

        // 16. Edit Distance (Levenshtein Distance)
        System.out.println("Edit distance between 'kitten' and 'sitting': " + editDistance("kitten", "sitting"));

        // 17. Rabin-Karp Substring Search
        System.out.println("Rabin-Karp index of 'ana' in 'banana': " + rabinKarp("banana", "ana"));

        // 18. Sliding Window Maximum (for string of digits, window size 3)
        System.out.println("Sliding window max in '123459876' (k=3): " + Arrays.toString(slidingWindowMax("123459876", 3)));
    }
    // 12. Longest Substring Without Repeating Characters (Optimal O(n))
    static int longestSubstringWithoutRepeating(String s) {
        int n = s.length(), maxLen = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // 13. Longest Palindromic Substring (Expand Around Center, O(n^2))
    static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // 14. Check if String is a Permutation of Another (O(n))
    static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[256];
        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) count[c]--;
        for (int i : count) if (i != 0) return false;
        return true;
    }

    // 15. String Compression (aabcccccaaa -> a2b1c5a3)
    static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

    // 16. Edit Distance (Levenshtein Distance, O(mn))
    static int editDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }

    // 17. Rabin-Karp Substring Search (O(n+m))
    static int rabinKarp(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int n = haystack.length(), m = needle.length();
        int base = 256, mod = 101;
        int h = 1;
        for (int i = 0; i < m - 1; i++) h = (h * base) % mod;
        int p = 0, t = 0;
        for (int i = 0; i < m; i++) {
            p = (base * p + needle.charAt(i)) % mod;
            t = (base * t + haystack.charAt(i)) % mod;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                if (haystack.substring(i, i + m).equals(needle)) return i;
            }
            if (i < n - m) {
                t = (base * (t - haystack.charAt(i) * h) + haystack.charAt(i + m)) % mod;
                if (t < 0) t += mod;
            }
        }
        return -1;
    }

    // 18. Sliding Window Maximum (for string of digits)
    static int[] slidingWindowMax(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && s.charAt(dq.peekLast()) <= s.charAt(i)) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = s.charAt(dq.peekFirst()) - '0';
        }
        return res;
    }

    // 1. Anagram Check (O(n))
    static boolean isAnagramEffective(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) if (count != 0) return false;
        return true;
    }

    // 1. Anagram Check (sorting)
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    // 2. Palindrome Check
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // 3. String Reversal
    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 4. Substring Search (Naive)
    static int substringSearch(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) return i;
        }
        return -1;
    }

    // 5. Character Frequency
    static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        return freq;
    }

    // 6. Remove Duplicates from String
    static String removeDuplicates(String s) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : s.toCharArray()) seen.add(c);
        StringBuilder sb = new StringBuilder();
        for (char c : seen) sb.append(c);
        return sb.toString();
    }

    // 7. String to Integer (atoi)
    static int stringToInt(String s) {
        int num = 0, i = 0, sign = 1;
        s = s.trim();
        if (s.isEmpty()) return 0;
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }
        return num * sign;
    }

    // 8. Integer to String
    static String intToString(int num) {
        return Integer.toString(num);
    }

    // 9. Longest Common Prefix
    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 10. String Rotation Check
    static boolean isRotation(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // 11. Contains Duplicate in Array (utility)
    static boolean containsDuplicateList(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if (!seenNumbers.add(num)) return true;
        }
        return false;
    }
}

