import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] arr, int target) {
    int count = 0;
    Arrays.sort(arr);
    for(int i  = 0; i < arr.length - 2; i++){
        int left = i + 1, right = arr.length - 1;
        while(left < right){
            int nowDiff = target - arr[i] - arr[left] - arr[right];
            if(nowDiff > 0){
                count += right - left;
                //记住这个时候是求数量，不是逐渐逼近，所以不能直接把他++，而是直接计算我们有多少个，然后再调整left的位             left++;
            } else if(nowDiff <= 0){
                right--;
            } 
        }
    }
    return count;
  }
}

//也可以利用嵌套函数来做

import java.util.*;
class TripletWithSmallerSum {
  public static int searchTriplets(int[] arr, int target) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      count += searchPair(arr, target - arr[i], i);
    }
    return count;
  }

  private static int searchPair(int[] arr, int targetSum, int first) {
    int count = 0;
    int left = first + 1, right = arr.length - 1;
    while (left < right) {
      if (arr[left] + arr[right] < targetSum) { // found the triplet
        // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between 
        // left and right to get a sum less than the target sum
        count += right - left;
        left++;
      } else {
        right--; // we need a pair with a smaller sum
      }
    }
    return count;
  }
  public static void main(String[] args) {
    System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
  }
}


