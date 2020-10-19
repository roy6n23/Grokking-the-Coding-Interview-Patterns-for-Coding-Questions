import java.util.*;
//是否存在重新排列，注意所有序列一定是连续的
//思路：利用滑动窗口，如果end滑动到的字符
//先遍历给定的pattern
//再遍历所需要求的str，首先不管是不是contains的，先right了再说，如果contians的话就减少相应的value
// 如果match的刚好是size，就return true
//如果遍历的大于总长度了，就要缩水前面的start，如果start稍微向右平移一个，如果contain之前的，就让他的value加一，如果不contain，好像没看懂。。。


class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int windowStart = 0;
    int matched = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for(char chr : pattern.toCharArray())
    	charFrequencyMap.put(chr,charFrequencyMap.getOrDefault(chr, 0) + 1);

    for( int windowEnd = 0; windowEnd < str.length(); windowEnd++){
    	char rightChar = str.charAt(windowEnd);
    	if(charFrequencyMap.contaninsKey(rightChar)){
    		charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
    		if(charFrequencyMap.get(rightChar) == 0)
    			matched++;
    	}

    	if(matched == charFrequencyMap.size())
    		return true;

    	if(windowEnd >= pattern.length() - 1){
    		char leftChar = str.charAt(windowStart++);
    		if(charFrequencyMap.constainsKey(leftChar)){
    			if(charFrequencyMap.get(leftChar) == 0)
    				matched--;

    			charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
    		}

    	}
    }
    return false;
  }
}
