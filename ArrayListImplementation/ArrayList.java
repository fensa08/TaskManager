package ArrayListImplementation;

import java.util.NoSuchElementException;

public class ArrayList<T> {

    private Node<T> head;
    private int size;

    public ArrayList() {
        this.head = null;
        size = 0;
    }



    public Node<T> getLastElement() throws EmptyListException {

        if (size == 0) {
            throw new EmptyListException();
        }

        if (size == 1)
            return head;

        Node<T> current = head;
        while (current.hasNext()) {
            current = current.getNext();
        }
        return current;
    }


    public void addElement(T element) throws ArrayIndexOutOfBoundsException {

        Node<T> node = new Node<>(element, null);

        if (size == 0) {
            this.head = node;
            size++;
            return;
        }

        Node<T> lastElement = getLastElement();
        lastElement.setNext(node);
        size++;
    }



    public void addElement(int position, T element) throws IndexOutOfBoundsException {

        if (position > size)
            throw new IndexOutOfBoundsException();

        if (position == size) {  // addToLastPosition
            Node<T> node = new Node<T>(element, null);
            getLastElement().setNext(node);
            size++;
            return;
        }


        Node<T> current = this.head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        Node<T> newNode = new Node<T>(element, current.getNext());
        current.setNext(newNode);
        size++;

    }



    public boolean containsElement(T element) throws EmptyListException{
        if(size == 0)
            throw new EmptyListException();
        if(head.getData().equals(element))
            return true;

        Node<T> current = this.head;
        while(current.hasNext()){
            current = current.getNext();
            if(current.getData().equals(element))
                return true;
        }
        return false;

    }


    public Node<T> getElement(T element) throws EmptyListException{

        if(size == 0)
            throw new EmptyListException();

        Node<T> curr = this.head;
        if(curr.getData().equals(element))
            return curr;


        while(curr.hasNext()){
            curr = curr.getNext();
            if(curr.getData().equals(element))
                return curr;
        }
        System.out.println("Elementot ne postoi vo listata");
        return null;
    }

    public Node<T>  getElementAt(int position) throws ArrayIndexOutOfBoundsException, NegativeArraySizeException{
        if(position > size)
            throw new ArrayIndexOutOfBoundsException();

        if(position == 0 && size > 0)
            return head;

        Node<T> current = head;
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        return current;
    }


    public T deleteLastElement() throws EmptyListException{
        if(size == 0)
            throw new EmptyListException();

        if(size == 1){
            size--;
            T element = head.getData();
            head = null;
            return element;
        }

        Node<T> curr = this.head;
        while(curr.hasNext()){
            if(!curr.getNext().hasNext()){
                T element = curr.getNext().getData();
                curr.setNext(null);
                size--;
                return element;
            }
            curr = curr.getNext();
        }
        return null;
    }

    // go brise prvoto pojavuvanje na elementot vo listata.
    public void deleteElement(T element) throws EmptyListException, NoSuchElementException {

        if (size == 0)  // prazna lista
            throw new EmptyListException();

        if (size == 1 && !head.getData().equals(element))   // lista so eden element
            throw new NoSuchElementException();

        if (size == 1 && head.getData().equals(element)) {

            head = null;
            size = 0;
            return ;
        }
        if (size != 1 && head.getData().equals(element)) {
            head = head.getNext();
            return;
        }


        Node<T> node = this.head;

        if (node.getNext().getData().equals(element)) {
            deleteNext(node.getNext());
            return;
        }

        while (node.hasNext()) {
            node = node.getNext();
            if (node.hasNext() && node.getNext().getData().equals(element)) {


                deleteNext(node);
                return;

                /*// ima sleden
                if (node.getNext().hasNext()) {
                    node.setNext(node.getNext().getNext());
                    return;
                }
                // nema sleden
                node.setNext(null);
                return;*/
            }
        }

        throw new NoSuchElementException();
    }


    public int getSize(){
        return this.size;
    }

    private void deleteNext(Node<T> node) {

        // ima sleden
        if (node.getNext().hasNext()) {
            node.setNext(node.getNext().getNext());
            return;
        }
        // nema sleden
        node.setNext(null);
        return;
    }


    @Override
    public String toString(){
        String output = "[";
        Node<T> curr = head;
        if(size != 0){
            while(curr.hasNext()){
                output += curr.getData() + ",";
                curr = curr.getNext();
            }
            output += curr.getData() + "]";
        }else{
            output += " ]";
        }
        return output;

    }

    public String printInReverseOrder(){
        String output = "";

        Node<T> curr = head;

        if(size != 0){
            output = curr.getData() + " " + output;
            while(curr.hasNext()){
                curr = curr.getNext();
                output = curr.getData() + " " + output;
            }
        }
        return output;

    }
    public String printInReverseOrderStacked(){
        String output = "";

        Node<T> curr = head;

        if(size != 0){
            output = curr.getData() + "\n " + output;
            while(curr.hasNext()){
                curr = curr.getNext();
                output = curr.getData() + "\n" + output;
            }
        }
        return output;

    }

}











