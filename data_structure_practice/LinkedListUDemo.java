public class LinkedListUDemo {
    public static void main(String[] args) {
        LinkedListU<Integer> ls = new LinkedListU<Integer>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.display();
        ls.delete();
        ls.display();
        
    }
}