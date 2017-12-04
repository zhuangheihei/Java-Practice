public class QueueArrayDemo {
    public static void main(String[] args){
        QueueArray<Integer> q = new QueueArray<Integer>(5);
        q.queue(1);
        q.queue(2);
        q.queue(3);
        q.queue(4);
        q.queue(5);
        q.queue(6);
        System.out.println("Dequeue:" + q.deQueue());
        System.out.println("Dequeue:" + q.deQueue());
    }
}