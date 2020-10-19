import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
   int windowStart = 0;
   int maxLength = 0;

   Map<Character, Integer> fruitMap = new HashMap<>();

   for (int windowEnd = 0; windowEnd < arr.length(); windowEnd++){
   		fruitMap.put(arr[windowEnd], fruitMap.getOrDefault(arr[windowEnd], 0) + 1);

   		while(fruitMap.size() > 2){
   			fruitMap.put(arr[windowStart], fruitMap.get(arr[windowStart]) - 1);
   			if(fruitMap.get(arr[windowStart]) == 0)
   				fruitMap.remove(arr[windowStart]);
   }
   maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
  }

  return maxLength;
}
