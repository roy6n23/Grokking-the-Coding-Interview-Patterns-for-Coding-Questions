import java.util.*;
class StringAnagrams {
	public static List<Integer> findStringAnagrams(String str, String pattern){
		int windowStart = 0, matched = 0;
		HashMap<Character, Integer> charFreqMap = new HashMap<>();
		LinkedList<Integer> result = new LinkedList<>();

		for(char chr : pattern.toCharArray()){
			charFreqMap.put(chr, charFreqMap.getOrDefault(chr, 0) + 1);
		}

		for(int windowEnd = 0; windowEnd< str.length(); windowEnd++){
			char rightChar = str.charAt(windowEnd);

			if(charFreqMap.containsKey(rightChar)){
				charFreqMap.put(rightChar, charFreqMap.get(rightChar)-1);
				if(charFreqMap.get(rightChar) == 0){
					matched++;
				}
			}

			if(matched == charFreqMap.size())
				result.add(windowStart);

			if(windowEnd >= pattern.length() -1){
				char leftChar = str.charAt(windowStart++);
				if(charFreqMap.containsKey(leftChar)){
					if(charFreqMap.get(leftChar) == 0)
						matched--;
					
					charFreqMap.put(leftChar, charFreqMap.get(leftChar) +1);
				}
			}
		}

		return result;
	}
}
