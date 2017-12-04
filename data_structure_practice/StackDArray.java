import java.util.Arrays;

public class StackDArray<T> {
    Object[] ArrayStack;
    int size;
    int top;
    
    public StackDArray(int size) { //initializing arraystack
        this.size = size;   //define the size
        ArrayStack = new Object[this.size]; //initialize the stack array
        top = -1; //define the pointer outside the stack
    }
    
    public boolean isFull(){
        return (top == size - 1); //obviously
    }
    
    public boolean isEmpty(){
        return (top == -1); //obviously
    }
    
    public void push(Object newItem){
        ensureCapacity(top+2);
        ArrayStack[++top] = newItem;
    }
    
    public T pop(){ //pop() should return some value
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        T item = (T) ArrayStack[top--];
        return item;
    }
    
    public void ensureCapacity(int minCapacity){
        int oldCapacity = ArrayStack.length;
        if(minCapacity > oldCapacity){
            int newCapacity = oldCapacity*2;
            if(newCapacity<minCapacity)
                newCapacity = minCapacity;
            ArrayStack = Arrays.copyOf(ArrayStack,newCapacity);
        }
    }
    
    public int getSize(){
        return ArrayStack.length;
    }
    
}