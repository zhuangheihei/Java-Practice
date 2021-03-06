public class StackArray<T> {
    Object[] ArrayStack;
    int size;
    int top;
    
    public StackArray(int size) { //initializing arraystack
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
        if(isFull()){ //make sure stack has space to push
            System.out.println("stack is full");
            return;
        }
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
    
}