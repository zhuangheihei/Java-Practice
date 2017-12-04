public class StackDArrayDemo {
    public static void main(String[] args){
        StackDArray<Integer> st = new StackDArray<Integer>(2);
        st.push(1);
        st.push(2);
        System.out.println("Size stack:"+ st.getSize());
        st.push(3);
        System.out.println("Size stack:"+ st.getSize());
        st.push(4);
        st.push(5);
        st.push(6);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
        st.pop();
    }
}