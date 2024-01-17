import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            boolean f1 = false;//to break the loop
            boolean f2 = false;//to break the loop
            // acquire
            while(i < s.length()-1){ // as we are strating from -1 to s.length -1(as baad me i++ hoga to out of bound idx aayega)
                f1 = true;
                i++;
                char ch = s.charAt(i);

                map.put(ch, map.getOrDefault(ch, 0)+1); // map me values put karo

                if(map.get(ch) == 2){ // jaise hi invalid hoga break kardo
                    break;
                }else{
                    int len = i-j; // len = i-j
                    ans = Math.max(len,ans);
                }
            }
            // release
            while(j < i){ // ab j ko tab tak chalao jab tak i ke equal na ho jae
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch)-1); // ch par aai har value ko kam karte jao aur tab tak karo jab tak jo invalid kar raha ho vo map me frequency 1 na ho jae aur jaise hi ho jae break kardo

                if(map.get(ch) == 1){
                    break;
                }
            }

            if(f1 == false && f2 == false){  // aab na vo first block me jaega na hi 2nd block me to bahar hi aayega to break kardo
                break;
            }
        }
        return ans;
    }
}