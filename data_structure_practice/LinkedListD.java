public class LinkedListD<T> {
    NodeD head;
    
    public LinkedListD() {
        head = null;
    }
    
    public void add(Object value) {
        NodeD newNode = new NodeD(value, null, null); //just creating node, no information about next node
        if(head == null) //if no any node
            head = newNode;
        else {
            newNode.next = head; //add new node ahead of head
            head.prev = newNode;
            head = newNode; //move head to new node
        }
    }
    
    public void delete() {
        head = head.next;
        head.prev = null;
    }
    
    public void display() {
        NodeD n = head;
        while(n != null){
            System.out.println((T)n.value);
            n = n.next;
        }
    }
}