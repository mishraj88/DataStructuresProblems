import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jmishra on 04-07-2017.
 */
public class MedianOfArrayElelemnts {

    public static double[] getMediansForArray(int[] input){
        double[] medians = new double[input.length];
        //maxHeap implementation of PriorityQueue
        PriorityQueue<Integer> lowerHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        //default minHeap implementation of PriorityQueue
        PriorityQueue<Integer> biggerHeap = new PriorityQueue<Integer>();
        for(int i=0; i< input.length; i++){
            int number = input[i];
            addNumberToAptHeap(number, lowerHeap, biggerHeap);
            rebalance(lowerHeap, biggerHeap);
            medians[i] = getMedian(lowerHeap, biggerHeap);
        }

        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> biggerHeap) {
        if( lowerHeap.size()== biggerHeap.size()){
              return ((double) lowerHeap.peek() + biggerHeap.peek())/2;
        }else{
            if(lowerHeap.size() > biggerHeap.size())
                return lowerHeap.peek();
            else
                return biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> biggerHeap) {
        PriorityQueue<Integer> lessSizedHeap = lowerHeap.size() < biggerHeap.size() ? lowerHeap : biggerHeap;
        PriorityQueue<Integer> bigSizedHeap = lowerHeap.size() < biggerHeap.size() ? biggerHeap : lowerHeap;
        do {
            if (bigSizedHeap.size() - lessSizedHeap.size() >= 2) {
                lessSizedHeap.add(bigSizedHeap.poll());
            }
        }while(bigSizedHeap.size() - lessSizedHeap.size() >= 2);
    }

    private static void addNumberToAptHeap(int number, PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> biggerHeap) {
        if(lowerHeap.size() == 0)
            lowerHeap.add(number);
        else {
            if (number < lowerHeap.peek()) {
                lowerHeap.add(number);
            } else {
                biggerHeap.add(number);
            }
        }
    }

    public static void main(String args[]){
        int[] input = {5, 7,9, 10, 8 ,15, 3, 2};
        //sorted order input: {2,3,5,7,8,9,10,15} = > median: (double)(7+8)/2 = 7.5
        double[] medians = getMediansForArray(input);
        System.out.println("Printing the input array for Median Function of each entry");
        for(int i=0; i< input.length; i++){
            System.out.println("input["+i+"]: "+input[i]);
        }
        System.out.println("\nPrinting the median array returned:");
        for(int i=0; i< medians.length; i++){
            System.out.println("medians["+i+"]: "+medians[i]);
        }
        System.out.println("Final answer: \n \tmedian for given input array is:  "+medians[medians.length-1]);
    }
}
