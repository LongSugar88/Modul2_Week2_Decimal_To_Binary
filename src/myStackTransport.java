public class myStackTransport<T> {
    private int capacity;
    private Object[] myArray;
    private int currentSize;

    myStackTransport(int size){
        myArray = new Object[size];
        this.capacity = size;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == capacity;
    }
    public void ensureCapacity(){
        if(isFull()){
            Object[] newArray = new Object[capacity*2];
            for (int i=0; i<currentSize; i++){
                newArray[i] = myArray[i];
            }
            myArray = newArray;
        }
    }
    public void push(T element){
        ensureCapacity();
        myArray[currentSize] = element;
        currentSize++;
    }
    public T pop(){
        currentSize--;
        return (T) myArray[currentSize];
    }
    public int size(){
        return currentSize;
    }
    public static void transToBinary(int number) {
        myStackTransport<Integer> myArrayBinary = new myStackTransport<>(10);
        int token = number;
        while (number != 0) {
            int a = number;
            int binaryElement = number%2;
            myArrayBinary.push(binaryElement);
            number = (number - binaryElement) /2;
        }
        String myStringBinary = "";
        while (!myArrayBinary.isEmpty()){
            myStringBinary+= myArrayBinary.pop();
        }
        System.out.println(token + " transport to binary: " + myStringBinary);
    }
}
