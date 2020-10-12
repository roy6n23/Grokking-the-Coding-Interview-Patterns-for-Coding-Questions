import java.util.*;

class Interval {
  int start = 0;
  int end = 0;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class NextInterval {
  public static int[] findNextInterval(Interval[] intervals) {
    int n = intervals.length;
    // heap for finding the maximum start
    PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
    // heap for finding the minimum end
    PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
    int[] result = new int[n];
    for (int i = 0; i < intervals.length; i++) {
      maxStartHeap.offer(i);
      maxEndHeap.offer(i);
    }

    // go through all the intervals to find each interval's next interval
    for (int i = 0; i < n; i++) {
      int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end' 
      result[topEnd] = -1; // defaults to -1
      if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
        int topStart = maxStartHeap.poll();
        // find the the interval that has the closest 'start'
        while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
          topStart = maxStartHeap.poll();
        }
        result[topEnd] = topStart;
        maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
    int[] result = NextInterval.findNextInterval(intervals);
    System.out.print("Next interval indices are: ");
    for (int index : result)
      System.out.print(index + " ");
    System.out.println();

    intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
    result = NextInterval.findNextInterval(intervals);
    System.out.print("Next interval indices are: ");
    for (int index : result)
      System.out.print(index + " ");
  }
}