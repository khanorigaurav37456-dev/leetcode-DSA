class MinStack {
    protected int[] data;
    protected int[] minData;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;
    int minPtr = -1;


    public MinStack(){
        this(DEFAULT_SIZE);
    }
    public MinStack(int size) {
        this.data = new int[size];
        this.minData = new int[size];
    }

    // public MinStack() {
        
    // }
    private void resize() {
    // double both arrays

            //double the array size
            int[] temp = new int[data.length * 2];
            //copy all prev item in new data

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        
        
            //double the array size
            int[] temp2 = new int[minData.length * 2];
            //copy all prev item in new data

            for (int i = 0; i < minData.length; i++) {
                temp2[i] = minData[i];
            }

            minData = temp2;
        
}
    
    public void push(int item) {
         if(isFull()){
            resize();
         }
        ptr++;
        data[ptr] = item;
        if(minPtr == -1){
            minPtr++;
            minData[minPtr] = item;
        } 
         else if(item < minData[minPtr]){
            minPtr++;
            minData[minPtr] = item;
        } else{
            minPtr++;
            minData[minPtr] = minData[minPtr-1];
        }
        
    }
    public boolean isFull() {
        return ptr == data.length -1; // ptr is at last index
    }
    
    public void pop() {
        //int removed = data[ptr];
        ptr--;
        minPtr--;
    }
    
    public int top() {
        return data[ptr];
    }
    
    public int getMin() {
        return minData[minPtr];
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */