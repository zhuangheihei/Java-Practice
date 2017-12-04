public class NodeD {
    Object value;
    NodeD next;
    NodeD prev;
    
    public NodeD(Object value, NodeD next, NodeD prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}