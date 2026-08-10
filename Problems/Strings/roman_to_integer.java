import java.util.*;

class Main {
    static final Map<Character, Integer> mp = Map.of(
        'I',1, 'V',5, 'X',10, 'L',50,
        'C',100, 'D',500, 'M',1000
    );

    public static int solve(String s) {
        int prev = 0;
        int ans = 0;
        
        for(int i = s.length()-1; i >= 0; i--) {
            int curr = mp.get(s.charAt(i));
            
            if(curr < prev) {
                ans -= curr;
            } else {
                ans += curr;
            }
            prev = curr;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int ans = solve(s);
        
        System.out.print("Integer conversion: ");
        System.out.println(ans);
    }
}