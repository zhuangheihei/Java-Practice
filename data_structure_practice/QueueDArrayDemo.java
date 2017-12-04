public class QueueDArrayDemo {
    public static void main(String[] args){
        QueueDArray<Integer> q = new QueueDArray<Integer>(2);
        q.queue(1);
        q.queue(2);
        System.out.println("queue size is:" + q.getSize());
        q.queue(3);
        System.out.println("queue size is:" + q.getSize());
    }
} 