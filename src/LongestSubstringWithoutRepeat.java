/*

Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

See Expected Output

 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String a) {

        int solution = 0;
        int length = a.length();
        Map<Character, Integer> map = new HashMap<>();


        for(int i =0, j=0; j<length; j++){
            if(map.containsKey(a.charAt(j))){
                i = Math.max(map.get(a.charAt(j)),i);
            }
            solution = Math.max(solution, j-i+1);
            map.put(a.charAt(j), j+1);
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println("The longest substring without repeating letters for \"abcabcbb\" is of length "+ lengthOfLongestSubstring("abcabcbb"));
        System.out.println("The longest substring without repeating letters for \"bbbbb\" is of length "+ lengthOfLongestSubstring("bbbbb"));
    }
}
