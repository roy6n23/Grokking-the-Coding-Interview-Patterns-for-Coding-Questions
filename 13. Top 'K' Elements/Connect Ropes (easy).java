import java.util.*;

class ConnectRopes {

  public static int minimumCostToConnectRopes(int[] ropeLengths) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    for(int i = 0; i < ropeLengths.length; i++){
      minHeap.add(ropeLengths[i]);
    }
    // int n = ropeLengths.length;
    // int temp = 0, result = minHeap.poll()*(n - 1);
    // for(int i  = 1; i < n; i++){
    //   temp = minHeap.poll();
    //   result += temp*(n - i);
    // }

    // return result;

    
    // go through the values of the heap, in each step take top (lowest) rope lengths from the min heap
    // connect them and push the result back to the min heap. 
    // keep doing this until the heap is left with only one rope
    int result = 0, temp = 0;
    while(minHeap.size() > 1){
      temp = minHeap.poll() + minHeap.poll();
      result += temp;
      minHeap.add(temp);
    }

    return result;
  }

  public static void main(String[] args) {
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}
