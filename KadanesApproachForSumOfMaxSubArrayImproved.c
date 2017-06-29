//maxSubArray in a given array with random integer entries

int[] maxSubArrayFunc(int[] arr, int index);

int maxSum(int[] a, int beginIndex, int endIndex);

int len(int[] a);
//int beginIndex, endIndex=0;
int main(){
	int[] a= {1,-3,2,1,-1};
	int sumMax=0;
	
	int i=0;
	int length = len(a);
	int[] maxSubArray = {-32768};
	while(i<length){
		maxSubArray=maxSubArrayFunc(a, i, maxSubArray);
		i++;
	}
	sumMax= maxSum(maxSubArray);
	printf("<MaxSum>:"+sumMax);
	printf("\n Max Sub Array Content");
	printf("[ ");
	while(beginIndex <=endIndex){
		printf("%d", a[beginIndex++]);
	}
	printf(" ]");
	
	return 0;
	
}

int maxSum(int[] arr){
	int i=0;
	int tempSum=0;
	int length = len(arr);
	while(i<length){
		tempSum = tempSum+a[i++];
	}
	
	return tempSum;
}

int[] compareArraySums(int index, int[] contestant_1, int[] contestant_2){
	if(maxSum(contestant_1) > maxSum(contestant_2)) {
		beginIndex=index;
		endIndex=index;
		return contestant_1;
	}
	else if(maxSum(contestant_1 ) == maxSum(contestant_2)){
		int length=len(contestant_2);
		beginIndex=index-length+1;
		endIndex = index;
		return contestant_2;
	} 
	else{
		int length=len(contestant_2);
		beginIndex=index-length+1;
		endIndex=index;
		return contestant_2; 
	} 
}

int[] maxSubArrayFunc(int[] arr, int index, int[] currentMax){
	//int length
	int length=len(currentMax);
	int i=0;
	int[] contestent_1 = {arr[index]};
	
	int[] contestant_2[length+1];
	for( i=0; i< length; i++){
		contestant_2[i]=currentmax[i];
	}
	contestant_2[i]=arr[index];
	return compareArraySums(index,contestant_1, contestant_2);
	
	
}
