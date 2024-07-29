package Day11;

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (p.length() > s.length()) {
            return "-1";
        }

        int[] pattern_freq = new int[128];
        int[] window_freq = new int[128];

        for (char ch : p.toCharArray()) {
            pattern_freq[ch]++;
        }

        int start = 0, min_len = Integer.MAX_VALUE, min_start = 0, count = 0;

        for (int end = 0; end < s.length(); end++) {
            char end_char = s.charAt(end);
            window_freq[end_char]++;

            if (pattern_freq[end_char] > 0 && window_freq[end_char] <= pattern_freq[end_char]) {
                count++;
            }

            while (count == p.length()) {
                if (end - start + 1 < min_len) {
                    min_len = end - start + 1;
                    min_start = start;
                }

                char start_char = s.charAt(start);
                window_freq[start_char]--;

                if (pattern_freq[start_char] > 0 && window_freq[start_char] < pattern_freq[start_char]) {
                    count--;
                }

                start++;
            }
        }

        return min_len == Integer.MAX_VALUE ? "-1" : s.substring(min_start, min_start + min_len);
    }
}