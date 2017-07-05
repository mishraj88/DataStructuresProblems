/**
 * Created by jmishra on 05-07-2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CollatzConjecture: This concept applies to positive integers and implies that it is always possible to
 * get back to 1, if we follow these steps
 * 1- if n=1, return 1
 * 2- if n is even, call collatzFunc(n/2)
 * 3- if n is odd, call collatzFunc(3n+1)

 */
public class CollatzConjucture {
    static int callCount=0;
    private int n;
    public CollatzConjucture(int n){
        this.n=n;
    }
    public int collatzFunc(int n){
        callCount++;
        System.out.println(callCount+": input num: "+n);
        if(n <= 0)
            return 0;
        if(n==1) {
            System.out.println("\nTotal calls: "+callCount);
            return 1;
        }
        else {
            if (n % 2 == 0)
                return collatzFunc(n/2);
            else
                return collatzFunc(3*n+1);
        }
    }
    public static void main(String args[]) throws IOException{
        System.out.println("Enter a number to pass to CollatzConjectureFunction: \n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        CollatzConjucture object = new CollatzConjucture(num);
        int result = object.collatzFunc(object.n);
        System.out.println("Result: "+result);

    }
}
