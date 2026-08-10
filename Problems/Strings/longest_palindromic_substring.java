// longest palindromic substring
import java.util.*;

class Main {
    static int helper(String s, int leftCenter, int rightCenter) {
        while(leftCenter >= 0 && rightCenter < s.length() && s.charAt(leftCenter) == s.charAt(rightCenter)) {
            leftCenter--;
            rightCenter++;
        }
        
        return rightCenter-leftCenter-1;
    }
    
    public static String solve(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < n; i++) {
            // odd length string
            int len1 = helper(s, i, i);
            // even length string
            int len2 = helper(s, i, i+1);
            
            int len = Math.max(len1, len2);
            
            // if a longer palindrome is found update start and end
            if(len > end-start+1) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public static void main(String[] args) {
        String s = "abba";
        String ans = solve(s);
        
        System.out.print("Longest Palindromic Substring: ");
        System.out.println(ans);
    }
}