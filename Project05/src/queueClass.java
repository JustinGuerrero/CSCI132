public class queueClass<E> implements Queue<E> {
     /**
     * Uses the Doulbly Linked List to work with a queue, by utilizing the methods found in Double linked list
     * you can implement methods to attach and remove nodes from the linked list. Along with a toString method
     * to print the list or array queue.
     */

    private DoublyLinkedList<E> koo = new DoublyLinkedList<>();


    @Override
    public int size() {
        return koo.size;
    }

    @Override
    public boolean isEmpty() {

        return koo.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        koo.addFirst(e);


    }

    @Override
    public E first() {
        return koo.last();
    }


    @Override
    public E dequeue() {
        return koo.removeLast();
    }

    @Override
    public String toString(){
        return koo.toString();
    }
}
