int count_negs_in_sorted_matrix(int[][] Matrix, int rows, int column)

int main(){
	count_negs_in_sorted_matrix(M, n, m);
}

int count_negs_in_sorted_matrix(int[][] Matrix, int rows, int column){
	//since the matrix is sorted both row wise and column wise
	//if a column starts with a positive integer, it can't have a negative number
	//once a column number has got first positive integer, all the previous entries in the row will be negative
	//so we just have to find first positive or last negative in 1st row and the second row will have negative number possibility
	//from the same column where you find the last negativev in the first row. Similar fashion would be followed in the later rows and immediate previous row
	
	int j = column-1;	//initialise i to last column index
	int i =0;
	int count=0;
	while(i<rows){
		while(j>=0){
			if(Matrix[i][j] >=0){
				j--;
				continue;
			}
			else{
				count=count+j+1;
				
				break;
			} 
		}
		i++;
	}
	return count;
}

