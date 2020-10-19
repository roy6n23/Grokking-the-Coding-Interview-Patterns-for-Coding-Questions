//-------Given an array, find the average of all contiguous subarrays of size ‘K’ in it.



//------------------Brute-force----------------
//------------------Brute-force----------------
//------------------Brute-force----------------
//------------------Brute-force----------------
//------------------Brute-force----------------
//------------------Brute-force----------------



import java.util.Arrays;

class  AverageOfSubarrayOfSizeK {


  public static double[] findAverages(int K, int[] arr) {
  	double[] result = new double[arr.length - K + 1];
  	for( int i = 0; i < arr.length - K; i++){

  		double sum = 0;
  		for (int j = i; j < i + K; j++)
  			sum += arr[j];
  		result[i] = sum / K;
  	}

  	return result;
  }

}

//--------Sliding Window-----------------
//--------Sliding Window-----------------
//--------Sliding Window-----------------
//--------Sliding Window-----------------
//--------Sliding Window-----------------
//--------Sliding Window-----------------


import java.util.Arrays;

class  AverageOfSubarrayOfSizeK {
  public static double[] findAverages(int K, int[] arr) {
  	double[] result = new double[arr.length - K + 1];
  	double windowSum = 0;
  	double windowStart = 0;
  	for( int windowEnd = 0; windowEnd < arr.length; windowEnd ++){
  		windowSum += arr[windowEnd];

  		if(windowEnd >= K - 1){
  			result[windowStart] = windowSum / K;
  			windowSum -= arr[windowStart];
  			windowStart++;
  		}
  	}

  	return result;
  }

}
