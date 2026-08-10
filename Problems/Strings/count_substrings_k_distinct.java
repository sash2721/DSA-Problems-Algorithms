// count substrings with k distinct characters
import java.util.*;

class Main {
    static int countKSubstrings(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;
        
        for(int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            
            while(freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                if(freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }
            
            count += right-left+1;
        }
        return count;
    }
    
    public static int solve(String s, int k) {
        // this is done so we can remove the substrings having k-1 distinct character
        // since k also contains k-1 substrings
        return countKSubstrings(s, k) - countKSubstrings(s, k-1);
    }
    
    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        int ans = solve(s, k);
        
        System.out.print("Number of substrings: ");
        System.out.println(ans);
    }
}