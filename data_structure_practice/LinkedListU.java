public class LinkedListU<T> {
    Node head;
    
    public LinkedListU() {
        head = null;
    }
    
    public void add(Object value) {
        Node newNode = new Node(value, null); //just creating node, no information about next node
        if(head == null) //if no any node
            head = newNode;
        else {
            newNode.next = head; //add new node ahead of head
            head = newNode; //move head to new node
        }
    }
    
    public void delete() {
        head = head.next;
    }
    
    public void display() {
        Node n = head;
        while(n != null){
            System.out.println((T)n.value);
            n = n.next;
        }
    }
}