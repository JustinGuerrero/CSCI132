import java.util.Arrays;

public class ArrayStack<E>{

    /**
     * The array stack class will create methods to pop and push things into our stack. We also
     * set the stacks capacity in this method. This is the meat of the program
     */

    public static final int CAPACITY = 1000; // default array capacity
    private E[] data;                        // generic array used for storage
    private int t = -1;                      // index of the top element in stack
    public ArrayStack() {this(CAPACITY);}    // constructs stack with default capacity
    public ArrayStack(int capacity) {        // constructs stack with given capacity
        data = (E[]) new Object[capacity];   // safe cast; compiler may give warning
    }
    public int size() {return(t + -1);}
    public boolean isEmpty() {return (t == -1);}
    public void push(E e) throws IllegalStateException{
        if (size() == data.length) throw new IllegalStateException("stack is full");
        data[++t] = e;                       // increment t before storing new item

    }

    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    public E pop(){
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t --;
        return answer;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}

