public class LinkedListDDemo {
    public static void main(String[] args) {
        LinkedListD<Integer> ls = new LinkedListD<Integer>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.display();
        ls.delete();
        ls.display();
    }
}