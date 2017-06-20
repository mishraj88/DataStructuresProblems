#include<stdio.h>

int sumOfMaxSubArray(int[] a);


int main(){
	int[] arr={1,-3,2,1,-1};
	int sum=sumOfMaxSubArray(arr);
	printf("SumOfMaxSubArray(): %d", sum);
	return sum;
}

int sumOfMaxSubArray(int[] a){
	//we are going to use Kadane's Algorithm for this
	//Kadane says: the maximumSumSubArray at an index: i in array: arr is like {arr[0]...arr[i], arr[i]}
	//for index zero, it is a[0], for i=1, it can be {a[0],a[1]} or {a[1]}
	//for index: 2 it can be (a[0],[1]), (a[1], a[2]), (a[0],a[1],a[2]) or a[2]

	//what we need to to do, is to compare maxSubArray till i-1 and maxSubArray at i and forget about the rest
	
	int i=0;
	
	
	int sumMax=a[0];
	int beginIndex=0;
	int endIndex=0;
	int tempBeginIndex=0;
	int tempEndIndex=0;
	
	int inputArrayLength = len(a);
	while(i<inputArrayLength){
		
		tempEndIndex=i;
		while(tempBeginIndex<=i){
			int k=tempBeginIndex;
			int tempSum=0;
			while(k<=tempEndIndex){
			
				tempSum= tempSum+arr[k++];
			
			}
			if(tempSum > sumMax){
				sumMax=tempSum;
				beginIndex=tempBeginIndex;
				endIndex= tempEndIndex;
			}
			tempBeginIndex++;
		}
		
		i++;
		tempBeginIndex=0;
	}
	
	
 
}