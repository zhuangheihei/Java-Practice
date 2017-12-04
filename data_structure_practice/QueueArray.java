public class QueueArray<T> { //T is used for generics
    //define its field;
    Object[] ArrayQueue;
    int rear;
    int front;
    int size;

    public QueueArray(int size){
        this.size = size; //define size
        ArrayQueue = new Object[this.size]; //initialize the queue
        front = -1;
        rear = -1;
    }
    
    public void queue(Object newItem){ //add newItem into the queue, the same as "add"
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        ArrayQueue[++rear] = newItem;
        if(front == -1)
            front = 0;
        
    }
    
    public T deQueue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return null;
        }
        T res = (T) ArrayQueue[front++]; //(T) convert to the target object
        return res;
    }
    
    public boolean isFull(){
        return (rear == size - 1);
    }
    
    public boolean isEmpty(){
        return (front == -1 || front > rear);
    }

}