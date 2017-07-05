/**
 * Created by jmishra on 03-07-2017.
 * given an array of integers, such that each Integer comes even number of times,
 * except one integer which has either an odd occurance or appears exactly once.
 * One typical solution is to use a HashMap, scan all integers in array and put those with their value as key
 * and occurance frequency as value. amd then make the comparisons and return the key value with met condition
 * Complexity: Time: O(n)
 *             Space: O(n)
 *
 * There is one more option to save the space and use the existing structure for the same
 * treat each numbers binary and count the last digit in the binary representation.
 * if all the odd numbers are twice in count/even in count we would have even number 1s there and similarly with even numbers
 * we will have even number of zeros
 * whichever is Odd will give us the hint of which number even or odd has come only once.
 * Further if you apply XOR on the bits at unit and then move ahead to bits at 10s place, 100s palce and so on
 * Final output which you would get would give you the lonely integer in the array.
 * So, instead of getting XOR on each individual bit, you may call XOR on each input with each new input you come across
 * while scanning the input array
 */
public class LonelyIntegerSolution {

    private static int[] array = {1,5,6,8,1,1,3,3,7,7,5,8,6,9,9};

    public static void main(String args[]){
        int result = getLonelyIntegerFromArray(array);
        System.out.println("Lonely integer : "+result);
    }

    public static int getLonelyIntegerFromArray(int[] array){
        int result =0;

        for(int value: array){
            result ^= value;
        }

        return result;
    }
}
