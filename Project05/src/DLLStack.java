public class DLLStack<E> implements Stack<E> {
    /**
     * Uses the Doulbly Linked List to work with a stack, by utilizing the methods found in Double linked list
     * you can implement methods to attach and remove nodes from the linked list. Along with a toString method
     * to print the list or array stack.
     */
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();


    @Override
    public int size() {
        return list.size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString(){
        return list.toString();
    }

}
