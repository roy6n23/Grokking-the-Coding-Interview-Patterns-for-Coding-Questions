import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 3)
      throw new IllegalArgumentException();

    Arrays.sort(arr);
    //smallestDifference is the now smallest one
    int smallestDifference = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        // comparing the sum of three numbers to the 'targetSum' can cause overflow
        // so, we will try to find a target difference
        int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
        if (targetDiff == 0) //  we've found a triplet with an exact sum
          return targetSum - targetDiff; // return sum of all the numbers

        // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
        if (Math.abs(targetDiff) < Math.abs(smallestDifference)
            || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
          smallestDifference = targetDiff; // save the closest and the biggest difference  

        if (targetDiff > 0)
          left++; // we need a triplet with a bigger sum
        else
          right--; // we need a triplet with a smaller sum
      }
    }
    return targetSum - smallestDifference;
  }

  public static void main(String[] args) {
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
  }
}