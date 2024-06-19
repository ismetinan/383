import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args)  {
        String ransomNote = "abc";
        String magazine = "abcd";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map2.containsKey(ch)) {
                map2.replace(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (Map.Entry<Character, Integer> entry2 : map2.entrySet()) {
                if (entry.getKey() == entry2.getKey()) {
                    if (entry.getValue() > entry2.getValue()) {
                        return false;
                    }
                } else if (!map2.containsKey(entry.getKey())){
                    return false;
                }
            }
        }
        return true;
        
    }
}
