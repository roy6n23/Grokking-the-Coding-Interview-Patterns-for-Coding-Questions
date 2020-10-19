import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {

    int windowStart = 0;
    int matched = 0;

    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for(char chr : pattern.toCharArray())
    	charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

    List<Integer> resultIndices = new ArrayList<Integer>();

    for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
    	char rightChar = str.charAt(windowEnd);

    	if(charFrequencyMap.containsKey(rightChar)){
    		charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
    		if(charFrequencyMap.get(rightChar) == 0)
    			matched++;
    	}

    	if(matched == charFrequencyMap.size())
    		resultIndices.add(windowStart);

    	if(windowEnd >= pattern.length() - 1){
    		char leftChar = str.charAt(windowStart++);
    		if(charFrequencyMap.get(leftChar) == 0)
    			matched--;

    		charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
    	}

    }

    return resultIndices;
  }
}
