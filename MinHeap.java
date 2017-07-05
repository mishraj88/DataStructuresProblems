import java.util.Arrays;

/**
 * Created by jmishra on 03-07-2017.
 */
public class MinHeap {

    private static int capacity = 10;
    private static int[] items = new int[capacity];


    static {
        items[0] = 3;
        items[1] = 4;
        items[2] = 8;
        items[3] = 9;
        items[4] = 7;
        items[5] = 10;
        items[6] = 9;
        items[7] = 15;
        items[8] = 20;
        items[9] = 13;
    }

    private static int size = items.length;



    public int getParentIndex(int index){
        return (index-1)/2;
    }
    public int getLeftChildIndex(int index){
        return (index*2)+1;
    }
    public int getRightChildIndex(int index){
        return (index*2)+2;
    }

    public boolean hasParent(int index){
        return (getParentIndex(index) < size);
    }
    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    public boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private void addValue(int value){
        if(items.length ==0){
            items[0] = value;
            return;
        }
        //size = items.length;
        ensureCapacity();
        items[size - 1] = value;
        size++;
        heapifyUp();
    }

    private void ensureCapacity() {
        //size = items.length;
        if(size == capacity){
            capacity *=2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    private int peek(){
        if(size == 0)
            throw new IllegalArgumentException("no elements in heap to peek");
        return items[0];
    }

    private int poll(){
        if(size == 0)
            throw new IllegalArgumentException("no elements in heap to poll");
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && items[getParentIndex(index)] < items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(){
        int index = 0;

        int smallChildIndex = getLeftChildIndex(index);
        while(items[index] > smallChildIndex ) {
            if (hasRightChild(index) && items[smallChildIndex] > items[getRightChildIndex(index)]) {
                smallChildIndex = getRightChildIndex(index);

            }
            swap(index, smallChildIndex);
            index = smallChildIndex;
            smallChildIndex = getLeftChildIndex(index);

        }

    }

    private void swap(int index1, int index2) {
        items[index1] = items[index1] + items[index2];
        items[index2] = items[index1] - items[index2];
        items[index1] = items[index1] - items[index2];
    }

    private static void printMyHeap(){
        for(int i =0; i< size; i++){
            System.out.println("items["+i+"]: "+items[i]);
        }
    }

    public static void main(String args[]){
        MinHeap obj = new MinHeap();
        obj.printMyHeap();
        int peekOriginal=obj.peek();
        System.out.println("\nPeek from original heap: "+peekOriginal );
        obj.addValue(25);
        System.out.println("\n Heap after calling addValue(25) to original minHeap \n");
        obj.printMyHeap();
        int peekAfterAdd = obj.peek();
        System.out.println("\nPeek after addValue(25) heap: "+peekAfterAdd );
        int poll = obj.poll();
        System.out.println("\n Poll to minHeap after addValue(25) is called: "+poll);
        System.out.println("\n Heap after calling addValue(25) and later  poll() to original minHeap \n");
        obj.printMyHeap();

    }
}
