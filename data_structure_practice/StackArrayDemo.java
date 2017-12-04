public class StackArrayDemo {
    public static void main(String[] args){
        StackArray<Integer> st = new StackArray<Integer>(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
        st.pop();
    }
}