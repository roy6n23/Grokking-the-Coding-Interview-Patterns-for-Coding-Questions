import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {

    int windowStart = 0;
    int matched = 0;

    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for(char chr : pattern.toCharArray())
    	charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    List<Integer> resultIndices = new ArrayList<Integer>();

    


  }
}
