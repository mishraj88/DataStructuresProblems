import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
   
    
	public static void main (String[] args) {
		Scanner sc =new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int j=0; j< testCase; j++){
		    int sizeOfArray = sc.nextInt();
		    int numOutputs =sc.nextInt();
		    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(numOutputs+1);
		    int count=0;
		    for(int i = 0; i< sizeOfArray; i++){
		        if(count<numOutputs){
		            pq.offer(sc.nextInt());
		            count++;
		        }else{
		            int newEntry = sc.nextInt();
		            int min = pq.peek();
		            if(newEntry > min){
		                pq.offer(sc.nextInt());
		                //count++;
		                pq.poll();
		                //count--;
		            }
		            
		        }
		        
		        
		        
		    }
		    
		    for(Integer i: pq)
		    	System.out.print(" "+i);
		   	
		    Stack<Integer> st = new Stack<Integer>();
		    for(int i=0; i<numOutputs;i++){
		        st.push(pq.poll());
		    }
		    for(Integer i: st)
		        System.out.println(i+" ");
		    st = null;
		    pq = null;
		}
		
		
	}
}
